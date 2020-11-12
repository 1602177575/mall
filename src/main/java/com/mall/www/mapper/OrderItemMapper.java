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

    /**
     * 根据订单id删除订单详情
     *
     * @param orderId
     * @return
     */
    int deleteByOrderId(@Param("orderId") Long orderId);

    /**
     * 根据订单id和商品id查询订单详情信息
     *
     * @param orderId 订单id
     * @param product 商品id
     * @return
     */
    OrderItem selectByOrderIdAndProductId(@Param("orderId") Long orderId, @Param("productId") Long product);
}
