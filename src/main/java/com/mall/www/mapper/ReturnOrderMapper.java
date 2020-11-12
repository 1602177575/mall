package com.mall.www.mapper;

import com.mall.www.entity.ReturnOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnOrderMapper {
    /**
     * 根据用户id查询退货订单
     *
     * @param userId
     * @return
     */
    List<ReturnOrder> selectListByUserId(@Param("userId") Long userId);

    /**
     * 添加
     *
     * @param returnOrder
     * @return
     */
    int insert(@Param("returnOrder") ReturnOrder returnOrder);

    /**
     * 根据用户id和订单id和商品id查询退货信息
     *
     * @param userId    用户id
     * @param orderId   订单id
     * @param productId 商品id
     * @return
     */
    ReturnOrder selectByUserIdAndOrderIdAndProductId(@Param("userId") Long userId, @Param("orderId") Long orderId, @Param("productId") Long productId);
}
