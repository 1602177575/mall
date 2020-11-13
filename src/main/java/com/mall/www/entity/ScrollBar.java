package com.mall.www.entity;

import lombok.Data;

@Data
public class ScrollBar {
    /**
     * 外键
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 滚动栏图片
     */
    private String scrollImage;

    /**
     * 滚动栏状态
     */
    private Integer isStatus;
}

