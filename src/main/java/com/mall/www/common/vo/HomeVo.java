package com.mall.www.common.vo;

import com.mall.www.entity.Carts;
import com.mall.www.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * 首页封装类
 */
@Data
public class HomeVo {

    /**
     * 标题
     */
    List<String> Tile;

    /**
     * 展示前三产品在首页
     */
    List<Object> first;
    List<Object> two;
    List<Object> three;
    /**
     * 猜你喜欢
     */
    List<ProductVo> like;


}
