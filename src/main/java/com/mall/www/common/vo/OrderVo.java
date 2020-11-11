package com.mall.www.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderVo {

    //订单编号
    private String orderNumber;

    //创建时间
    private Date createTime;

    //支付状态：0->未支付,1->已支付
    private Integer paymentStatus;

    //支付方式：1->网上支付,2->银行汇款,3->货到付款
    private Integer paymentType;

    //收件人
    private String name;

    //手机号
    private String phone;

    //固定电话
    private String fixedPhone;

    //邮编
    private String postcode;

    //所在地区
    private String area;

    //详情地址
    private String detailAddress;

    //订单的状态：0->待支付,1->待收货，2->已完成的订单，3->已取消
    private Integer orderStatus;

    //赠送的积分
    private Integer giftPoint;

    //总金额
    private BigDecimal totalMoney;

    /**
     * 优惠卷id
     */
    private Long couponId;

    //商品列表
    List<OrderItemVo> productList;
    //
}
