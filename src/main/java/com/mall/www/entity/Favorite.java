package com.mall.www.entity;

import lombok.Data;

@Data
public class Favorite {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 商品ID
     */
    private Long pid;

    /**
     * 状态
     */
    private Integer isStatus;
}

