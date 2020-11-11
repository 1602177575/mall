package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.service.CouponService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    CouponService couponService;

    /**
     * 查询用户的所有优惠卷
     *
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity list(Long userId) {
        return ResponseEntity.success(couponService.list(userId));
    }

}
