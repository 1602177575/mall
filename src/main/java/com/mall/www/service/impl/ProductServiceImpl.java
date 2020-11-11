package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.DetailsProductBo;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.ProductMapper;
import com.mall.www.service.ProductService;
import com.mall.www.utils.ColaBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;


    @Override
    public List<ProductVo> selectKeyName(String name) {
        List<ProductVo> list=new ArrayList<>();
        try {
            List<Product> product = productMapper.selectProductByName(name);
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
        }catch (Exception e){
            throw new ServiceException(StatusCode.KEY_ERROR);
        }finally {
            return list;
        }
    }

    @Override
    public DetailsProductVo selectProductDetails(Long pid) {
        DetailsProductVo vo = null;
        try {
            DetailsProductBo pro = productMapper.selectProductDetails(pid);
            if(pro==null){
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }else {
                vo = new DetailsProductVo();
                  ColaBeanUtils.copyProperties(pro,vo);
            }
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally{
            return vo;
        }
    }

    @Override
    public List<Object> selectLikeTop() {
        List<Object> list=null;
        try {
            list = Collections.singletonList(productMapper.selectLikeTop());
        }catch (Exception e){
            throw  new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }
}
