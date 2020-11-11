package com.mall.www.common.bo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetailsProductBo {
    private Long productId; //商品ID
    private String productName; //商品名称
    private String productTitle; //商品标题
    private String description; //商品描述
    private String pic; //商品图片
    private String albumPics; //画册图片，连产品图片限制为5张
    private BigDecimal price; //价格
    private BigDecimal promotionPrice; //促销价格
    private Integer categoryId; //分类id

    private String pid;//商品ID
    private String packing;//主体信息
    private String subject;//品牌
    private String facade;//外观
    private String system;//系统
    private String cpu;
    private String notwork;//网络
    private String stockpile;//内存
    private String screen;//屏幕




}
