package com.mall.www.common.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponVo {

    //优惠卷id
    private Long couponId;

    //面值,优惠金额
    private BigDecimal value;

    //最小金额：如果是满减需要到多少金额才减
    private BigDecimal minimum;

    //生效时间
    private Date beginTime;

    //失效时间
    private Date invalidTimme;

    //优惠卷的状态:1->可使用,2->已使用,3->已过期
    private Integer status;

    //优惠卷类型:1->满减,2->无门槛,3->可拆分
    private Integer type;
}
