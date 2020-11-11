package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.vo.HomeVo;
import com.mall.www.exception.ServiceException;
import com.mall.www.service.CategoryService;
import com.mall.www.service.HomeService;
import com.mall.www.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    ProductService productService;
    @Resource
    CategoryService categoryService;

    @Override
    public HomeVo selectHome(Integer tile, Integer num) {
        HomeVo homeVo=new HomeVo();
        try {
            homeVo.setTile(categoryService.selectCategoryTopTile(tile));
            homeVo.setFirst(categoryService.selectCategoryTopById(1,num));
            homeVo.setTwo(categoryService.selectCategoryTopById(2,num));
            homeVo.setThree(categoryService.selectCategoryTopById(3,num));
            homeVo.setLike(productService.selectLikeTop());
        }catch (Exception e){
            throw  new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return homeVo;
        }
    }

}
