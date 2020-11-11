package com.mall.www.mapper;

import com.mall.www.entity.ReturnOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnOrderMapper {
    /**
     * 根据用户id查询退货订单
     * @param userId
     * @return
     */
    List<ReturnOrder> selectListByUserId(@Param("userId") Long userId);
}
