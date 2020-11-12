package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.dto.ReturnOrderDto;
import com.mall.www.entity.Order;
import com.mall.www.entity.OrderItem;
import com.mall.www.entity.ReturnOrder;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.OrderItemMapper;
import com.mall.www.mapper.OrderMapper;
import com.mall.www.mapper.ReturnOrderMapper;
import com.mall.www.service.ReturnOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {
    @Resource
    ReturnOrderMapper returnOrderMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    /**
     * 根据用户id获取退货订单列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<ReturnOrder> list(Long userId) {
        List<ReturnOrder> returnOrderList = null;
        try {
            returnOrderList = returnOrderMapper.selectListByUserId(userId);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return returnOrderList;
        }
    }

    /**
     * 创建退货记录
     *
     * @param returnOrderDto
     * @return
     */
    @Transactional
    @Override
    public boolean create(ReturnOrderDto returnOrderDto) {
        boolean flag = false;
        try {
            //根据订单id查询订单信息
            Order order = orderMapper.selectByOrderId(returnOrderDto.getOrderId());
            if (order.getOrderStatus() != 1) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            //根据用户id、订单id、商品id查询退货信息
            ReturnOrder temp = returnOrderMapper.selectByUserIdAndOrderIdAndProductId(returnOrderDto.getUserId(), returnOrderDto.getOrderId(), returnOrderDto.getProductId());
            if (temp != null) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            //设置值
            ReturnOrder returnOrder = new ReturnOrder();
            BeanUtils.copyProperties(returnOrderDto, returnOrder);
            //根据订单id和商品id查询订单详情信息
            OrderItem orderItem = orderItemMapper.selectByOrderIdAndProductId(returnOrderDto.getOrderId(), returnOrder.getProductId());
            BeanUtils.copyProperties(orderItem, returnOrder);
            int i = returnOrderMapper.insert(returnOrder);
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
}
