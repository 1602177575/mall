package com.mall.www.common.bo;

import com.mall.www.entity.Product;
import lombok.Data;

@Data
public class ScrollBarBo {
    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 滚动栏图片
     */
    private String scrollImage;

    /**
     * 商品
     */
    private Product product;
}
