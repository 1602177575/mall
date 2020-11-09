package com.mall.www.service.impl;

import com.mall.www.common.vo.Details_productVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.mapper.ProductMapper;
import com.mall.www.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;


    @Override
    public List<ProductVo> selectKeyName(String name) {
        List<Product> product = productMapper.selectProductByName(name);
        List<ProductVo> list=new ArrayList<>();
        product.forEach(pro->{
            ProductVo vo = new ProductVo();
            vo.setProductName(pro.getProductName());
            vo.setPic(pro.getPic());
            vo.setPrice(pro.getPrice());
            vo.setProduct_id(pro.getProductId());
            vo.setPromotionPrice(pro.getPromotionPrice());
            list.add(vo);
        });
        return list;
    }

    @Override
    public Details_productVo selectProductDetails(Integer pid) {
        Product pro = productMapper.selectProductDetails(pid);

        Details_productVo vo = new Details_productVo();
        vo.setProductName(pro.getProductName());
        vo.setProductTitle(pro.getProductTitle());
        vo.setAlbumPics(pro.getAlbumPics());
        vo.setDescription(pro.getDescription());
        vo.setPic(pro.getPic());
        vo.setPrice(pro.getPrice());
        vo.setPromotionPrice(pro.getPromotionPrice());
        vo.setCategoryId(pro.getCategoryId());
        return vo;
    }

    @Override
    public List<Object> selectLikeTop() {
        return null;
    }
}
