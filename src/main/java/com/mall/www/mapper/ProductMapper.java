package com.mall.www.mapper;

import com.mall.www.common.bo.DetailsProductBo;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductVo;
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
    DetailsProductBo selectProductDetails(Long pid);

    Product selectByProductId(@Param("productId") Long productId);

    List<Product> selectListByProductIds(@Param("productIds") List<Long> productIds);

    /**
     * 猜你喜欢 展示销量最好的产品
     * @return
     */
    List<Product> selectLikeTop();


    /**
     * 展示广告滚动栏上的商品
     * @param value 展示的条数
     * @return
     */
    List<ProductVo> selectScrollBar(Integer value);

}
