package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.vo.HomeVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.service.CategoryService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.mall.www.service.HomeService;
import com.mall.www.service.ProductService;
import org.springframework.web.bind.annotation.*;

/**
 * 展示主页数据
 *
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    HomeService homeService;
    @Resource
    ProductService productService;

    /**
     * 展示主页数据
     * @param tile 展示前几条标题
     * @param product 前三分类 各多少个产品数据
     * @return
     */
    @PostMapping("/index")
    public ResponseEntity<HomeVo> index(@RequestParam(defaultValue = "5") Integer tile,@RequestParam(defaultValue = "6") Integer product){
        HomeVo homeVo = homeService.selectHome(tile, product);
        return ResponseEntity.success(homeVo);
    }


    /**
     * 模糊查询其商品名字
     * @param name 商品名字
     * @return
     */
    @PostMapping("/search")
    public ResponseEntity<List<ProductVo> >selectKeywordName(@RequestParam(required = true,value = "name")String  name){
        return ResponseEntity.success(productService.selectKeyName(name));
    }

}
