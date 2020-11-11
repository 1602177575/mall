package com.mall.www.service;

public interface StockService {
    /**
     * 根据商品id修改库存数量
     *
     * @param productId 商品id
     * @param quantity  库存要加的数量
     * @return
     */
    int updateStock(Long productId, Integer quantity);
}
