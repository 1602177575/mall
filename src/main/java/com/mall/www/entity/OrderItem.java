package com.mall.www.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItem {
    /**
     * 主键，订单详情id
     */
    private Long orderItemId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品图片
     */
    private String productPic;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 销售价格
     */
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    private Integer productQuantity;

    /**
     * 配送方式：0->普通快递,1->顺丰快递,2->圆通快递
     */
    private Integer deliveryType;

    /**
     * 物流单号
     */
    private String trackingNumber;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

