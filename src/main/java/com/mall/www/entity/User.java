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
     * 邮箱
     */
    private String email;

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
     * 生日
     */
    private String birthday;

    /**
     * 身份 学生-自由职业
     */
    private String identity;

    /**
     * 婚姻状态
     */
    private String is_marital;

    /**
     * 家庭成员
     */
    private String member;

    /**
     * 个人收入 状况
     */
    private Double income;

    /**
     * 是否有车 0无 1有
     */
    private Integer is_cart;

    /**
     * 1->未删除，0->已删除
     */
    private Integer is_dele;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

