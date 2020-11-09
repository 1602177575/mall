package com.mall.www.entity;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Product {
    /**
     * 主键
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品标题
     */
    private String productTitle;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 图片
     */
    private String pic;

    /**
     * 画册图片，连产品图片限制为5张
     */
    private String albumPics;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 促销价格
     */
    private BigDecimal promotionPrice;

    /**
     * 赠送的积分
     */
    private Integer giftPoint;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

