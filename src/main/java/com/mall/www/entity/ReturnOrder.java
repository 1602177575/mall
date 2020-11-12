package com.mall.www.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ReturnOrder {
    /**
     * 主键
     */
    private Long returnOrderId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 退货原因
     */
    private String returnReason;

    /**
     * 退款支付类型
     */
    private Integer refundType;

    /**
     * 退款说明
     */
    private String refundInstructions;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String productPic;

    /**
     * 商品的单价
     */
    private BigDecimal productPrice;

    /**
     * 商品的数量
     */
    private Integer productQuantity;

    /**
     * 赠送的积分
     */
    private Integer giftPoint;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 状态：0->待审,1->已完成,2->审核不通过
     */
    private Integer status;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

