package com.mall.www.service;

import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    /**
     * 根据商品名字 模糊查询商品
     * @param name 商品名字
     * @return
     */
    List<ProductVo> selectKeyName(String name);


    /**
     * 查询商品的详情
     * @param pid 商品的ID
     * @return
     */
    DetailsProductVo selectProductDetails(Long pid);


    /**
     * 展示销量最好的 猜你喜欢产品
     * @return
     */
    List<Object> selectLikeTop();

}
