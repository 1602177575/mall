package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.vo.HomeVo;
import com.mall.www.exception.ServiceException;
import com.mall.www.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    ProductService productService;
    @Resource
    CategoryService categoryService;
    @Resource
    AdvertisingService advertisingService;
    @Resource
    ScrollBarService scrollBarService;

    @Override
    public HomeVo selectHome(Integer tile, Integer num) {
        HomeVo homeVo=new HomeVo();
        try {
            homeVo.setTile(categoryService.selectCategoryTopTile(tile)); //标题
            homeVo.setScrollBar(scrollBarService.selectScrollBar(3)); //滚动栏信息
            homeVo.setAdvertising(advertisingService.selectAdvertising(4)); //广告栏
            homeVo.setFirst(categoryService.selectCategoryTopById(1,num)); //分类推荐1
            homeVo.setTwo(categoryService.selectCategoryTopById(2,num)); //分类推荐2
            homeVo.setThree(categoryService.selectCategoryTopById(3,num)); //分类推荐3
            homeVo.setLike(productService.selectLikeTop()); //猜你喜欢
        }catch (Exception e){
            throw  new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return homeVo;
        }
    }

}
