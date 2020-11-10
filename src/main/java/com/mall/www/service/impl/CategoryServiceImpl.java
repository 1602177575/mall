package com.mall.www.service.impl;

import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.mapper.CategoryMapper;
import com.mall.www.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    //limit  (curPage-1)*pageSize,pageSize
    @Override
    public List<Object> selectCategoryByIdList(Integer pid, Integer curPage, Integer pageSize) {
        List<Object> list=new ArrayList<>();
        List<Product> products = categoryMapper.selectCategoryList(pid, ((curPage - 1) * pageSize), pageSize);
        products.forEach(product->{
            ProductVo cvo = new ProductVo();
            cvo.setProduct_id(product.getProductId());
            cvo.setPic(product.getPic());
            cvo.setProductName(product.getProductName());
            cvo.setPrice(product.getPrice());
            cvo.setPromotionPrice(product.getPromotionPrice());
            list.add(cvo);
        });
        return list;
    }

    @Override
    public List<String> selectCategoryTop(Integer value) {
        List<String> topCategoryName = categoryMapper.selectCategoryTopName(value);
        return topCategoryName;
    }

    @Override
    public List<Object> selectCategoryTopById(Integer cid, Integer value) {
        List<Product> product = categoryMapper.selectCategoryTopById(cid, value);
        List<Object> list=new ArrayList<>();
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


}
