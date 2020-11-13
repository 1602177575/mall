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
     * 广告滚动栏
     */
    List<ScrollBarVo> ScrollBar;

    /**
     * 广告推荐位
     */
    List<AdvertisingVo> Advertising;
    /**
     * 展示前三产品在首页
     */
    List<ProductVo> first;
    List<ProductVo> two;
    List<ProductVo> three;
    /**
     * 猜你喜欢
     */
    List<ProductVo> like;


}
