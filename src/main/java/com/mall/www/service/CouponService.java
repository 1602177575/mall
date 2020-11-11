package com.mall.www.service;

import com.mall.www.entity.Coupon;

import java.util.List;

public interface CouponService {
    /**
     * 根据用户id查询优惠信息
     * @param userId
     * @return
     */
    List<Coupon> list(Long userId);
}
