package com.mall.www.service;

import com.mall.www.common.dto.OrderDto;
import com.mall.www.common.dto.OrderSearchDto;
import com.mall.www.common.vo.OrderPrepareVo;
import com.mall.www.common.vo.OrderVo;

import java.util.List;

public interface OrderService {
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
    OrderPrepareVo prepare(OrderDto orderDto);

    /**
     * 创建订单
     * 判断商品是否下架
     * 判断库存是否充足
     * 判断价格是否发生改变
     * 判断优惠卷是否有效
     * 计算总金额
     * 保存订单
     * 保存订单详细
     * 删除购物车列表
     * 删除优惠卷
     *
     * @param orderDto
     * @return
     */
    OrderVo create(OrderDto orderDto);

    /**
     * 支付成功后根据订单id修改订单的状态
     * 修改支付的状态
     * 修改订单的状态
     * 修改库存
     * 保存出库记录
     *
     * @param orderId 订单id
     * @return
     */
    OrderVo updatePaymentStatus(Long orderId);

    /**
     * 根据用户id查询订单列表信息
     *
     * @param userId 用户id
     * @return
     */
    List<OrderVo> list(Long userId);

    /**
     * 根据订单id删订单
     *
     * @param orderId 订单id
     * @return
     */
    boolean delete(Long orderId);

    /**
     * 根据订单id查询订单详情信息
     *
     * @param orderId 订单id
     * @return
     */
    OrderVo getOrder(Long orderId);

    /**
     * 根据条件查询用户的订单信息
     *
     * @param orderSearchDto        封装的条件对象
     * @return
     */
    List<OrderVo> listByCondition(OrderSearchDto orderSearchDto);
}
