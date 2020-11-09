package com.mall.www.common.dto;

import lombok.Data;

@Data
public class CartsDto {
    //用户id
    private Long userId;
    //商品id
    private Long productId;
    //添加的数量
    private Integer quantity;
}
