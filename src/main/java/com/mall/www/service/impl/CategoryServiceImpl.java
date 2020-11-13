package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.vo.CategoryVo;
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
    public CategoryVo selectCategoryByIdList(Integer cid, Integer curPage, Integer pageSize) {
        CategoryVo vo=new CategoryVo();
        List<ProductVo> pvo=new ArrayList<>();
        //获取商品总数
        int sum = categoryMapper.selectSumList(cid);
        //商品总页数
        int number=sum%pageSize==0?sum/pageSize:(sum/pageSize)+1;
        vo.setSum(number);
        //当前页数无法大于最大页数 无法小于最小页数
        int thisCurPage=curPage>number?number:curPage<number?1:curPage;
        try {
            List<Product> products = categoryMapper.selectCategoryList(cid, ((thisCurPage - 1) * pageSize), pageSize);
            products.forEach(product->{
                ProductVo cvo = new ProductVo();
                cvo.setProduct_id(product.getProductId());
                cvo.setPic(product.getPic());
                cvo.setProductName(product.getProductName());
                cvo.setPrice(product.getPrice());
                cvo.setPromotionPrice(product.getPromotionPrice());
                pvo.add(cvo);
            });
            vo.setList(pvo);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return vo;
    }

    @Override
    public List<String> selectCategoryTopTile(Integer value) {
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
    public List<ProductVo> selectCategoryTopById(Integer cid, Integer value) {
        List<ProductVo> list=new ArrayList<>();
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
