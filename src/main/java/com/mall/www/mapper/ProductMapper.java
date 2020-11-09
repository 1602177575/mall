package com.mall.www.mapper;

import com.mall.www.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {


    /**
     * 根据商品名字模糊查询商品
     * @param name
     * @return
     */
    List<Product> selectProductByName(@Param("pName") String name);


    /**
     * 查询商品的详情信息
     * @param pid 产品ID
     * @return
     */
    Product selectProductDetails(Integer pid);


    /**
     * 猜你喜欢 展示销量最好的产品
     * @return
     */
    List<Product> selectLikeTop();



}
