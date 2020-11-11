package com.mall.www.mapper;

import com.mall.www.entity.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    /***
     *  根据用户id查询可用的优惠卷信息
     * @param userId 用户id
     * @return
     */
    List<Coupon> selectListByUserId(@Param("userId") Long userId);

    /**
     * 根据优惠卷id查询优惠卷信息
     *
     * @param couponId 优惠卷id
     * @return
     */
    Coupon selectByCouponId(@Param("couponId") Long couponId);

    /**
     * 根据优惠卷id删除优惠卷信息
     *
     * @param couponId
     * @return
     */
    int deleteByCouponId(@Param("couponId") Long couponId);

    /**
     * 查询所有优惠卷包括已使用、可用、已过期的
     *
     * @param userId
     * @return
     */
    List<Coupon> selectList(@Param("userId") Long userId);
}
