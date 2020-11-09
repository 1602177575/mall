package com.mall.www.common.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品列表中 商品缩略图信息
 */
@Data
public class ProductVo {
    private int product_id;//产品ID
    private String productName; //商品名称
    private String pic;      //图片
    private BigDecimal price;   //商品价格
    private BigDecimal promotionPrice;  //商品促销价格
}
