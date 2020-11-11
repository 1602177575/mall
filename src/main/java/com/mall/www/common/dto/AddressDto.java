package com.mall.www.common.dto;

import lombok.Data;

@Data
public class AddressDto {
    //地址id
    private Long addressId;

    //用户id
    private Long userId;

    //收件人
    private String name;

    //所在地区
    private String area;

    //详情地址
    private String detailAddress;

    //手机号
    private String phone;

    //固定电话
    private String fixedPhone;

    //邮编
    private String postcode;

    //邮箱
    private String email;

    //地址别名
    private String addressAlias;

}
