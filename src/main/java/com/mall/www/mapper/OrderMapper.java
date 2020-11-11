package com.mall.www.mapper;

import com.mall.www.common.bo.OrderBo;
import com.mall.www.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    int insert(@Param("order") Order order);

    /**
     * 根据订单id查询订单
     *
     * @param orderId
     * @return
     */
    Order selectByOrderId(@Param("orderId") Long orderId);

    /**
     * 根据订单id修改订单的支付状态
     *
     * @param orderId       订单id
     * @param paymentStatus 支付状态
     * @return
     */
    int updatePaymentStatusByOrderId(@Param("orderId") Long orderId, @Param("status") Integer paymentStatus);

    /**
     * 根据订单id修改订单的状态
     *
     * @param orderId     订单id
     * @param orderStatus 订单的状态
     * @return
     */
    int updateOrderStatusByOrderId(@Param("orderId") Long orderId, @Param("status") Integer orderStatus);

    /**
     * 根据用户id查订单信息  订单表 订单详情表
     * 一对多
     *
     * @param userId
     * @return
     */
    List<OrderBo> selectListByUserId(@Param("userId") Long userId);

    /**
     * 根据订单id删订单
     *
     * @param orderId 订单id
     * @return
     */
    int deleteByOrderId(@Param("orderId") Long orderId);

    /**
     * 根据订单id查询订单信息 订单表 订单详情表
     * 一对多
     *
     * @param orderId
     * @return
     */
    OrderBo selectOrderBoByOrderId(@Param("orderId") Long orderId);
}
