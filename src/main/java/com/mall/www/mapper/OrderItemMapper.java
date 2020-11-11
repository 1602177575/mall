package com.mall.www.mapper;

import com.mall.www.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    /**
     * 添加订单详情
     *
     * @param orderItem
     * @return
     */
    int insert(@Param("orderItem") OrderItem orderItem);

    /**
     * 根据订单id查询订单详情列表
     *
     * @param orderId
     * @return
     */
    List<OrderItem> selectListByOrderId(@Param("orderId") Long orderId);
}
