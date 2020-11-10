package com.mall.www.controller;


import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;

    /**
     * 展示商品详情
     * @param pid 商品ID
     * @return
     */
    public DetailsProductVo selectProductDetails(@RequestParam(required = true) Integer pid){
        DetailsProductVo details = productService.selectProductDetails(pid);

        return details;
    }

}
