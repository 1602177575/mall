package com.mall.www.common.dto;

import com.mall.www.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    //用户id
    private Long userId;

    //地址id
    private Long addressId;

    //支付方式：1->网上支付,2->银行汇款,3->货到付款
    private Integer paymentType;

    //商品集合
    List<OrderItemDto> productList;

    //优惠卷id
    private Long couponId;
}
