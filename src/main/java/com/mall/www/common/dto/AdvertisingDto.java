package com.mall.www.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdvertisingDto implements Serializable {

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

}
