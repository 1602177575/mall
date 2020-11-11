package com.mall.www.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemVo {
    //商品id
    private Long productId;

    //商品图片
    private String productPic;

    //商品名称
    private String productName;

    //销售价格
    private BigDecimal productPrice;

    //购买数量
    private Integer productQuantity;

    //配送方式：0->普通快递,1->顺丰快递,2->圆通快递
    private Integer deliveryType;

    //物流单号
    private String trackingNumber;
}
