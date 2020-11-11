package com.mall.www.mapper;

import com.mall.www.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    /**
     * 根据商品id集合查询库存列表
     *
     * @param productIds 商品id集合
     * @return
     */
    List<Stock> selectByProductIds(@Param("productIds") List<Long> productIds);

    /**
     * 根据商品id查询库存
     *
     * @param productId
     * @return
     */
    Stock selectByProductId(@Param("productId") Long productId);

    /**
     * 根据商品id修改总库存
     * @param productId 商品id
     * @param total 总库存
     * @return
     */
    int updateTotalByProductId(@Param("productId") Long productId, @Param("total") Long total);

}
