package com.mall.www.entity;

import lombok.Data;

@Data
public class Carts {
    /**
     * 主键,购物车id
     */
    private Long cartId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

