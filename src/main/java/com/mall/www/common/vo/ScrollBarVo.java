package com.mall.www.common.vo;

import com.mall.www.entity.Product;
import lombok.Data;

@Data
public class ScrollBarVo {

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 滚动栏图片
     */
    private String scrollImage;


}
