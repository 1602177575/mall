package com.mall.www.entity;

import lombok.Data;

@Data
public class User {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机
     */
    private String phone;

    /**
     * 1->未删除，0->已删除
     */
    private Integer isDele;
}

