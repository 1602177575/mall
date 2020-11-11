package com.mall.www.mapper;

import com.mall.www.entity.Stock;
import com.mall.www.entity.StockOut;
import org.apache.ibatis.annotations.Param;

public interface StockOutMapper {
    /**
     * 添加出库记录
     * @param stockOut
     * @return
     */
    int insert(@Param("stockOut") StockOut stockOut);
}
