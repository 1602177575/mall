package com.mall.www.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartsVo {
    //购物车id
    private Long cartId;
    //商品id
    private Long productId;
    //商品的图片
    private String pic;
    //商品名称
    private String productName;
    //商品的价格
    private BigDecimal price;
    //商品的促销价
    private BigDecimal promotionPrice;
    //商品的积分
    private Integer giftPoint;
    //数量
    private Integer quantity;
}
