package com.mall.www.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Coupon {
    /**
     * 主键,优惠卷id
     */
    private Long couponId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 面值,优惠金额
     */
    private BigDecimal value;

    /**
     * 最小金额：如果是满减需要到多少金额才减
     */
    private BigDecimal minimum;

    /**
     * 商家id
     */
    private Long creatorId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 生效时间
     */
    private Date beginTime;

    /**
     * 失效时间
     */
    private Date invalidTimme;

    /**
     * 优惠卷类型:1->满减,2->无门槛,3->可拆分
     */
    private Integer type;

    /**
     * 优惠卷的状态:1->可使用,2->已使用,3->已过期
     */
    private Integer status;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

