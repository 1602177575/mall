package com.mall.www.common.vo;

import com.mall.www.entity.Product;
import lombok.Data;

@Data
public class FavoriteVo {
    private Integer id; //主键
    private Long productId;//商品ID
    private Integer uid;//用户ID
    private Integer isStatus;  //状态  默认0  1为删除
    private Product product; //商品信息
}
