package com.mall.www.mapper;

import com.mall.www.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    /**
     * 根据商品id集合查询库存列表
     * @param productIds    商品id集合
     * @return
     */
    List<Stock> selectByProductIds(@Param("productIds") List<Long> productIds);

}
