package com.mall.www.common.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderSearchDto {
    //用户id
    private Long userId;
    //商品名称
    private String productName;
    //订单编号
    private String orderNumber;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //支付方式：1->网上支付,2->银行汇款,3->货到付款
    private Integer paymentType;
    //收件人
    private String name;
    //最小金额
    private BigDecimal minMoney;
    //最大金额
    private BigDecimal maxMoney;
    //配送方式：0->普通快递,1->顺丰快递,2->圆通快递
    private Integer deliveryType;
}
