package com.mall.www.controller;

import com.mall.www.common.vo.Details_productVo;
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
    @PostMapping("title")
    public List<String> selectTitle(@RequestParam(defaultValue = "5") Integer value){
        List<String> title = categoryService.selectCategoryTop(value);
        return title;
    }

    /**
     * 主页展示各类商品的推荐产品
     * @param cid 产品分类
     * @param value 产品数量 默认6个
     * @return
     */
    @PostMapping("/pro_top")
    public List<Object> selectProductTop(Integer cid, @RequestParam(defaultValue = "6") Integer value){
        List<Object> list = categoryService.selectCategoryTopById(cid, value);
        return list;
    }


    /**
     * 根据其商品的ID 查询其商品详情信息
     * @param pid
     * @return
     */
    @PostMapping("/Details")
    public Object selectProductDetails(Integer pid){
        Details_productVo product = productService.selectProductDetails(pid);
        return product;
    }


    /**
     * 猜你喜欢 展示销量最多的几款产品
     * @return
     */
    @PostMapping("/likeTop")
    public List<Object> selectLikeTop(){

        return null;
    }


}
