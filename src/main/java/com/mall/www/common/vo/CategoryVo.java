package com.mall.www.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {

    Integer sum; //总页数
    List<ProductVo> list; //商品
}
