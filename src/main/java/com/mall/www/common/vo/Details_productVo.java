package com.mall.www.common.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情信息
 */
@Data
public class Details_productVo {
    private String productName; //商品名称
    private String productTitle; //商品标题
    private String description; //商品描述
    private String pic; //商品图片
    private String albumPics; //画册图片，连产品图片限制为5张
    private BigDecimal price; //价格
    private BigDecimal promotionPrice; //促销价格
    private Integer categoryId; //分类id

}
