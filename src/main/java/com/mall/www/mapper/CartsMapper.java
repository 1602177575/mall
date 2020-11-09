package com.mall.www.mapper;

import com.mall.www.common.bo.CartsBo;
import com.mall.www.entity.Carts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartsMapper {
    /**
     * 根据用户id查询购物信息
     *
     * @param userId 用户id
     * @return 购物车信息集合
     */
    List<CartsBo> selectList(@Param("userId") Long userId);

    /**
     * 添加购物车信息
     *
     * @param carts 购物车信息
     * @return 影响行数
     */
    int insert(@Param("cart") Carts carts);

    /**
     * 根据用户id和商品id查询购物车信息
     *
     * @param userId    用户id
     * @param productId 商品id
     * @return 影响行数
     */
    Carts selectByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

    /**
     * 根据购物id修改购物商品的数量
     *
     * @param cartId   购物车id
     * @param quantity 商品的数量
     * @return 影响行数
     */
    int updateQuantityByCartId(@Param("cartId") Long cartId, @Param("quantity") Integer quantity);

    /**
     * 根据购物车id删除购物车信息
     * @param cartIds   购物车id集合
     * @return
     */
    int deleteByCartIds(@Param("cartIds") List<Long> cartIds);
}
