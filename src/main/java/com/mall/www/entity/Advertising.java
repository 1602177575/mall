package com.mall.www.entity;

import lombok.Data;

/**
 * 广告信息表
 */
@Data
public class Advertising {
    private Integer id;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 广告主标题 广告语
     */
    private String advertisementTitle;

    /**
     * 广告副标题
     */
    private String advertisementSubhead;

    /**
     * 广告推广图片
     */
    private String promotionImage;

    /**
     * 广告状态 0存在 1删除
     */
    private Integer isStatus;
}