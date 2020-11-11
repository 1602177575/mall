package com.mall.www.mapper;

import com.mall.www.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

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
}
