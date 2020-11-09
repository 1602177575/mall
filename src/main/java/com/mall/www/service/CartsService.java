package com.mall.www.service;

import com.mall.www.common.dto.CartsDto;
import com.mall.www.common.vo.CartsVo;
import com.mall.www.entity.Carts;

import java.util.List;

public interface CartsService {
    /**
     * 根据用户id查询购物车信息
     *
     * @param userId 用户id
     * @return 购物车信息集合
     */
    List<CartsVo> list(Long userId);

    /**
     * 根据用户id和商品id修改购物车商品的数量
     *
     * @param cartsDto 封装了用户id和商品id
     * @return 购物车信息集合
     */
    List<CartsVo> updateProductQuantity(CartsDto cartsDto);

    /**
     * 添加购物信息到数据库
     *
     * @param carts 购物车信息
     * @return 添加数据的条数
     */
    int addCart(Carts carts);

    /**
     * 根据购物id删除购物信息
     *
     * @param cartIds 购物车集合
     * @return 删除数据的条数
     */
    int deleteCarts(List<Long> cartIds);
}
