package com.mall.www.entity;

import lombok.Data;

@Data
public class Address {
    /**
     * 主键
     */
    private Long addressId;

    /**
     *
     */
    private Long userId;

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
     *
     */
    private String postcode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址别名
     */
    private String addressAlias;

    /**
     * 默认发货地址：0->否；1->是
     */
    private Integer sendStatus;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

