package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.DetailsProductBo;
import com.mall.www.common.utils.ColaBeanUtils;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.exception.ServiceException;
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
    public List<ProductVo> selectLikeTop() {
        List<Product> list;
        List<ProductVo> vo=new ArrayList<>();
        try {
            list = productMapper.selectLikeTop();
            list.forEach(p->{
                ProductVo v = new ProductVo();
                v.setPic(p.getPic());
                v.setPrice(p.getPrice());
                v.setProduct_id(p.getProductId());
                v.setProductName(p.getProductName());
                v.setPromotionPrice(p.getPromotionPrice());
                vo.add(v);
            });
        }catch (Exception e){
            throw  new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return vo;
        }
    }
}
