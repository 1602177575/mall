package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.CategoryMapper;
import com.mall.www.service.CategoryService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
        try {
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
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return list;
    }

    @Override
    public List<String> selectCategoryTop(Integer value) {
        List<String> topCategoryName=null;
        try {
            topCategoryName = categoryMapper.selectCategoryTopName(value);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return topCategoryName;
        }
    }

    @Override
    public List<Object> selectCategoryTopById(Integer cid, Integer value) {
        List<Object> list=new ArrayList<>();
        try {
            List<Product> product = categoryMapper.selectCategoryTopById(cid, value);
            product.forEach(pro->{
                ProductVo vo = new ProductVo();
                vo.setProductName(pro.getProductName());
                vo.setPic(pro.getPic());
                vo.setPrice(pro.getPrice());
                vo.setProduct_id(pro.getProductId());
                vo.setPromotionPrice(pro.getPromotionPrice());
                list.add(vo);
            });
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }


}
