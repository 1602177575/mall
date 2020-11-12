package com.mall.www.common.dto;

import lombok.Data;

@Data
public class ReturnOrderDto {
    //用户id
    private Long userId;
    //订单id
    private Long orderId;
    //退货原因
    private String returnReason;
    //退款支付类型
    private Integer refundType;
    //退款说明
    private String refundInstructions;
    //商品id
    private Long productId;
}
