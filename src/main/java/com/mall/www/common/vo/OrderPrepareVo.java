package com.mall.www.common.vo;

import com.mall.www.entity.Address;
import com.mall.www.entity.Coupon;
import lombok.Data;

import java.util.List;

@Data
public class OrderPrepareVo {
    //地址列表信息
    List<Address> addressList;

    //商品列表信息
    List<CartsVo> productList;

    //优惠卷列表信息
    List<CouponVo> couponList;
}
