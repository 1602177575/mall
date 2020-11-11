package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.entity.Coupon;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.CouponMapper;
import com.mall.www.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    CouponMapper couponMapper;

    /**
     * 根据用户id查询所有优惠卷包括已使用、可用、已过期的
     *
     * @param userId
     * @return
     */
    @Override
    public List<Coupon> list(Long userId) {
        List<Coupon> coupons = null;
        try {
            coupons = couponMapper.selectList(userId);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return coupons;
        }
    }
}
