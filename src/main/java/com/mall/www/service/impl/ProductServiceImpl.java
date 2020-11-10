package com.mall.www.service.impl;

import com.mall.www.common.bo.DetailsProductBo;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.mapper.ProductMapper;
import com.mall.www.service.ProductService;
import org.springframework.beans.BeanUtils;
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
            vo.setProduct_id(pro.getProductId());
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
    public DetailsProductVo selectProductDetails(Long pid) {
        DetailsProductBo pro = productMapper.selectProductDetails(pid);

        System.out.println(pro.toString());

        DetailsProductVo vo = new DetailsProductVo();
        //基本信息

        //详情信息
        BeanUtils.copyProperties(pro,vo);
        return vo;
    }

    @Override
    public List<Object> selectLikeTop() {
        return null;
    }
}
