package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.OrderBo;
import com.mall.www.common.dto.CartsDto;
import com.mall.www.common.dto.OrderDto;
import com.mall.www.common.dto.OrderItemDto;
import com.mall.www.common.dto.OrderSearchDto;
import com.mall.www.common.utils.ColaBeanUtils;
import com.mall.www.common.utils.SnowflakeIdUtils;
import com.mall.www.common.vo.*;
import com.mall.www.entity.*;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.*;
import com.mall.www.service.CartsService;
import com.mall.www.service.OrderService;
import com.mall.www.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TOW = 2;
    public static final int THREE = 3;
    //地址表
    @Resource
    AddressMapper addressMapper;

    //商品表
    @Resource
    ProductMapper productMapper;

    //优惠卷表
    @Resource
    CouponMapper couponMapper;

    //库存表
    @Resource
    StockMapper stockMapper;

    //订单表
    @Resource
    OrderMapper orderMapper;

    //订单详情表
    @Resource
    OrderItemMapper orderItemMapper;

    //出库表
    @Resource
    StockOutMapper stockOutMapper;

    //购物车Service
    @Resource
    CartsService cartsService;

    //库存Servic
    @Resource
    StockService stockService;

    /**
     * 订单准备工作
     * 根据用户id和商品id，及购买的数量进行查询
     * 查询： 地址（用户选择）
     * 商品信息
     * 优惠卷（用户选择）
     *
     * @param orderDto
     * @return
     */

    @Override
    public OrderPrepareVo prepare(OrderDto orderDto) {
        OrderPrepareVo orderPrepareVo = new OrderPrepareVo();
        try {
            //根据用户id 查询地址列表
            List<Address> addressList = addressMapper.selectList(orderDto.getUserId());
            orderPrepareVo.setAddressList(addressList);

            //商品信息
            List<CartsVo> productList = new ArrayList<>();
            List<OrderItemDto> products = orderDto.getProductList();
            products.forEach(product -> {
                //查询商品信息
                Product temp = productMapper.selectByProductId(product.getProductId());
                CartsVo cartsVo = new CartsVo();
                //拷贝
                BeanUtils.copyProperties(temp, cartsVo);
                //设置商品数量
                cartsVo.setQuantity(product.getProductQuantity());
                productList.add(cartsVo);
            });
            orderPrepareVo.setProductList(productList);

            //优惠卷
            List<Coupon> coupons = couponMapper.selectListByUserId(orderDto.getUserId());
            long time = new Date().getTime();
            coupons.forEach(coupon -> {
                //筛选在有效范围的
                long beginTime = coupon.getBeginTime().getTime();
                long invalidTimme = coupon.getInvalidTimme().getTime();
                if (beginTime < time || time > invalidTimme) {
                    coupons.remove(coupon);
                }
                //排除
                //..
            });
            List<CouponVo> couponList = ColaBeanUtils.copyListProperties(coupons, CouponVo::new);
            orderPrepareVo.setCouponList(couponList);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return orderPrepareVo;
        }
    }


    /**
     * 创建订单
     * 判断商品是否下架
     * 判断库存是否充足
     * 判断价格是否发生改变
     * 判断优惠卷是否有效
     * 设置订单信息
     * 计算总金额
     * 保存订单
     * 保存订单详细
     * 删除购物车列表
     * 删除优惠卷
     *
     * @param orderDto
     * @return
     */
    @Transactional
    @Override
    public OrderVo create(OrderDto orderDto) {
        OrderVo orderVo = new OrderVo();
        try {
            //判断用户id是否为空
            if (orderDto.getUserId() == null) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            //获取前端发送商品的信息
            List<OrderItemDto> productList = orderDto.getProductList();
            //把商品id放到集合中进行查询
            List<Long> productIds = new ArrayList<>();
            productList.forEach(product -> {
                productIds.add(product.getProductId());
            });
            //根据商品id集合查询商品信息
            List<Product> products = productMapper.selectListByProductIds(productIds);

            //判断商品是否下架
            if (productIds == null || products.size() != productList.size()) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }

            //判断价格是否发生改变
            if (checkProductPrice(productList, products)) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }

            //根据商品id集合查询库存信息
            List<Stock> stockList = stockMapper.selectByProductIds(productIds);

            //判断库存是否不足
            if (stockList == null || stockList.size() != productList.size() || checkUnderstock(productList, stockList)) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }

            //根据优惠卷id查询优惠卷信息
            Coupon coupon = couponMapper.selectByCouponId(orderDto.getCouponId());

            //判断优惠卷是否无效
            if (checkCouponIsInvalid(coupon)) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            //保存订单
            Order order = new Order();
            //设置订单编号
            String orderNumber = String.valueOf(new SnowflakeIdUtils().nextId());
            order.setOrderNumber(orderNumber);
            //根据地址id查询地址信息
            Address address = addressMapper.selectById(orderDto.getAddressId());
            //设置地址信息
            BeanUtils.copyProperties(address, order);
            //设置用户id
            order.setUserId(orderDto.getUserId());
            //设置优惠卷id
            order.setCouponId(orderDto.getCouponId());
            //设置支付方式
            order.setPaymentType(orderDto.getPaymentType());
            BigDecimal totalMoney = new BigDecimal(BigDecimal.ZERO.longValue());
            //计算金额
            for (OrderItemDto orderItemDto : productList) {
                totalMoney = totalMoney.add(orderItemDto.getProductPrice().multiply(new BigDecimal(orderItemDto.getProductQuantity())));
            }
            //减去优惠卷面值
            totalMoney = totalMoney.subtract(coupon.getValue());

            order.setTotalMoney(totalMoney);

            //删除优惠卷
            couponMapper.deleteByCouponId(coupon.getCouponId());

            //保存订单
            orderMapper.insert(order);
            Long orderId = order.getOrderId();

            //保存详情订单
            for (OrderItemDto orderItemDto : productList) {
                //设置订单详情相关信息
                OrderItem orderItem = new OrderItem();
                BeanUtils.copyProperties(orderItemDto, orderItem);
                orderItem.setOrderNumber(orderNumber);
                orderItem.setOrderId(orderId);
                orderItem.setTrackingNumber(String.valueOf(new SnowflakeIdUtils().nextId()));
                orderItemMapper.insert(orderItem);
            }

            //删除购物车信息（减去购物车的数量）
            for (OrderItemDto orderItemDto : productList) {
                CartsDto cartsDto = new CartsDto();
                cartsDto.setUserId(orderDto.getUserId());
                cartsDto.setProductId(orderItemDto.getProductId());
                cartsDto.setQuantity(ZERO - orderItemDto.getProductQuantity());
                cartsService.updateProductQuantity(cartsDto);
            }
            //设置Vo对象
            BeanUtils.copyProperties(orderMapper.selectByOrderId(orderId), orderVo);
            orderVo.setCouponId(coupon.getCouponId());
            List<OrderItem> orderItems = orderItemMapper.selectListByOrderId(orderId);
            List<OrderItemVo> orderItemVos = ColaBeanUtils.copyListProperties(orderItems, OrderItemVo::new);
            orderVo.setProductList(orderItemVos);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return orderVo;
        }
    }

    /**
     * 支付成功后根据订单id修改订单的状态
     * 修改支付的状态
     * 修改订单的状态
     * 修改库存
     * 保存出库记录
     * 设置vo对象中的值
     *
     * @param orderId 订单id
     * @return
     */
    @Transactional
    @Override
    public OrderVo updatePaymentStatus(Long orderId) {
        OrderVo orderVo = new OrderVo();
        try {
            //根据订单id获取订单信息
            Order order = orderMapper.selectByOrderId(orderId);
            //根据订单id获取订单详情信息
            List<OrderItem> orderItems = orderItemMapper.selectListByOrderId(orderId);
            //获取商品id集合
            List<Long> productIds = new ArrayList<>();
            orderItems.forEach(orderItem -> {
                productIds.add(orderItem.getProductId());
            });
            //根据商品id集合获取库存信息
            List<Stock> stocks = stockMapper.selectByProductIds(productIds);
            List<OrderItemDto> orderItemDtos = ColaBeanUtils.copyListProperties(orderItems, OrderItemDto::new);

            //判断库存是否不足
            if (stocks == null || stocks.size() != orderItems.size() || checkUnderstock(orderItemDtos, stocks)) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }

            //修改订单的状态
            orderMapper.updatePaymentStatusByOrderId(orderId, ONE);
            orderMapper.updateOrderStatusByOrderId(orderId, ONE);

            //修改库存
            orderItems.forEach(orderItem -> {
                stockService.updateStock(orderItem.getProductId(), ZERO - orderItem.getProductQuantity());
            });
            //记录出库
            orderItems.forEach(orderItem -> {
                StockOut stockOut = new StockOut();
                stockOut.setOrderId(orderItem.getOrderId());
                stockOut.setProductId(orderItem.getProductId());
                stockOut.setQuantity(orderItem.getProductQuantity());
                stockOutMapper.insert(stockOut);
            });
            //设置vo对象的值
            BeanUtils.copyProperties(order, orderVo);
            List<OrderItemVo> orderItemVos = ColaBeanUtils.copyListProperties(orderItems, OrderItemVo::new);
            orderVo.setProductList(orderItemVos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return orderVo;
        }
    }

    /**
     * 根据用户id查询订单列表信息
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<OrderVo> list(Long userId) {
        List<OrderVo> orderVos = new ArrayList<>();
        try {
            //一对多查询
            //根据用户id查询订单信息和订单详情信息
            List<OrderBo> orderBos = orderMapper.selectListByUserId(userId);
            orderBos.forEach(orderBo -> {
                OrderVo orderVo = new OrderVo();
                BeanUtils.copyProperties(orderBo, orderVo);
                List<OrderItemVo> orderItemVos = ColaBeanUtils.copyListProperties(orderBo.getOrderItemList(), OrderItemVo::new);
                orderVo.setProductList(orderItemVos);
                orderVos.add(orderVo);
            });
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return orderVos;
        }
    }

    /**
     * 根据订单id删订单
     *
     * @param orderId 订单id
     * @return
     */
    @Transactional
    @Override
    public boolean delete(Long orderId) {
        boolean flag = false;
        try {
            //根据订单id删除订单表的信息
            int i = orderMapper.deleteByOrderId(orderId);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            //根据订单id删除订单详情表的信息
            i = orderItemMapper.deleteByOrderId(orderId);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            flag = true;
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return flag;
        }
    }

    /**
     * 根据订单id查询订单详情信息
     *
     * @param orderId 订单id
     * @return
     */
    @Override
    public OrderVo getOrder(Long orderId) {
        OrderVo orderVo = new OrderVo();
        try {
            OrderBo orderBo = orderMapper.selectOrderBoByOrderId(orderId);
            BeanUtils.copyProperties(orderBo, orderVo);
            List<OrderItemVo> orderItemVos = ColaBeanUtils.copyListProperties(orderBo.getOrderItemList(), OrderItemVo::new);
            orderVo.setProductList(orderItemVos);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return orderVo;
        }
    }

    /**
     * @param orderSearchDto 封装的条件对象
     * @return
     */
    @Override
    public List<OrderVo> listByCondition(OrderSearchDto orderSearchDto) {
        List<OrderVo> orderVos = new ArrayList<>();
        try {
            List<OrderBo> orderBos = orderMapper.selectListByCondition(orderSearchDto);
            orderBos.forEach(orderBo -> {
                OrderVo orderVo = new OrderVo();
                BeanUtils.copyProperties(orderBo, orderVo);
                List<OrderItemVo> orderItemVos = ColaBeanUtils.copyListProperties(orderBo.getOrderItemList(), OrderItemVo::new);
                orderVo.setProductList(orderItemVos);
                orderVos.add(orderVo);
            });
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return orderVos;
        }
    }

    /**
     * 判断价格是否发生改变
     *
     * @param orderItemDtos 前端的商品集合
     * @param products      数据库的商品集合
     * @return true->发生改变，false->未发生改变
     */
    private boolean checkProductPrice(List<OrderItemDto> orderItemDtos, List<Product> products) {
        for (OrderItemDto orderItemDto : orderItemDtos) {
            for (Product product : products) {
                if (orderItemDto.getProductId() == product.getProductId()) {
                    if (orderItemDto.getProductPrice().compareTo(product.getPromotionPrice()) != 0)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断库存是否不足
     *
     * @param orderItemDtos 前端的商品集合
     * @param stockList     数据库的库存集合
     * @return true->不足，false->充足
     */
    private boolean checkUnderstock(List<OrderItemDto> orderItemDtos, List<Stock> stockList) {
        for (OrderItemDto orderItemDto : orderItemDtos) {
            for (Stock stock : stockList) {
                if (orderItemDto.getProductId() == stock.getProductId()) {
                    if (orderItemDto.getProductQuantity() > stock.getTotal() - stock.getReservation()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断优惠卷是否无效
     *
     * @param coupon 优惠卷
     * @return true->无效，false->有效
     */
    private boolean checkCouponIsInvalid(Coupon coupon) {
        long time = new Date().getTime();
        long beginTime = coupon.getBeginTime().getTime();
        long invalidTimme = coupon.getInvalidTimme().getTime();
        if (time < beginTime || time > invalidTimme) {
            return true;
        } else {
            return false;
        }
    }
}
