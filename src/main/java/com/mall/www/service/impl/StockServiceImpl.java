package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.entity.Stock;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.StockMapper;
import com.mall.www.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService {
    @Resource
    StockMapper stockMapper;

    /**
     * 根据商品id修改库存数量
     *
     * @param productId 商品id
     * @param quantity  库存要加的数量
     * @return
     */
    @Transactional
    @Override
    public int updateStock(Long productId, Integer quantity) {
        try {
            //根据商品id获取库存信息
            Stock stock = stockMapper.selectByProductId(productId);
            if (stock == null) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
            //根据商品id修改总库存
            stockMapper.updateTotalByProductId(productId, stock.getTotal() + quantity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 0;
        }


    }
}
