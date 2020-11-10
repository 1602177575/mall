package com.mall.www.mapper;

import com.mall.www.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * 添加订单
     * @param order
     * @return
     */
    int insert(@Param("order") Order order);

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    Order selectByOrderId(@Param("orderId") Long orderId);
}
