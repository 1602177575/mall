package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

import com.mall.www.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;

    /**
     * 展示分类标题
     * @param value 展示标题的数量 默认5个
     * @return
     */
    @PostMapping("/title")
    public ResponseEntity<List<String>> selectTitle(@RequestParam(defaultValue = "5") Integer value){
       return ResponseEntity.success(categoryService.selectCategoryTop(value));
    }

    /**
     * 主页展示各类商品的推荐产品
     * @param cid 产品分类
     * @param value 产品数量 默认6个
     * @return
     */
    @PostMapping("/pro_top")
    public ResponseEntity<List<Object>> selectProductTop(Integer cid, @RequestParam(defaultValue = "6") Integer value){
        return ResponseEntity.success(categoryService.selectCategoryTopById(cid, value));
    }


    /**
     * 根据其商品的ID 查询其商品详情信息
     * @param pid
     * @return
     */
    @PostMapping("/Details")
    public ResponseEntity<Object> selectProductDetails(Long pid){
       return ResponseEntity.success(productService.selectProductDetails(pid));
    }


    /**
     * 猜你喜欢 展示销量最多的几款产品
     * @return
     */
    @PostMapping("/likeTop")
    public ResponseEntity<List<Object>> selectLikeTop(){
        return ResponseEntity.success(productService.selectLikeTop());
    }


}
