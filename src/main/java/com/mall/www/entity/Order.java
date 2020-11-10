package com.mall.www.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Order {
    /**
     * 主键
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 支付状态：0->未支付,1->已支付
     */
    private Integer paymentStatus;

    /**
     * 支付方式：1->网上支付,2->银行汇款,3->货到付款
     */
    private Integer paymentType;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 收件人
     */
    private String name;

    /**
     * 所在地区
     */
    private String area;

    /**
     * 详情地址
     */
    private String detailAddress;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 固定电话
     */
    private String fixedPhone;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 订单的状态：0->待支付,1->待收货，2->已完成的订单，3->已取消
     */
    private Integer orderStatus;

    /**
     * 优惠卷id
     */
    private Long couponId;

    /**
     * 赠送的积分
     */
    private Integer giftPoint;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

