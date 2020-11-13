package com.mall.www.common.bo;

import com.mall.www.entity.Product;
import lombok.Data;

@Data
public class AdvertisingBo {

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
     * 商品
     */
    private Product product;
}
