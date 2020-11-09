package com.mall.www.controller;


import com.mall.www.common.vo.Details_productVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Product;
import com.mall.www.service.CategoryService;
import com.mall.www.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cate")
public class CategoryController {

    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;

    /**
     *
     * @param cid
     * @param curPage 当前页数 默认第一页
     * @param pageSize 一页的商品数量 默认8个
     * @param cid 必传 类别ID
     * @return
     */
    @PostMapping("/category")
    @ResponseBody
    public List<Object> SelectCategory(@RequestParam(required=true)Integer cid, @RequestParam(defaultValue="1")Integer curPage, @RequestParam(defaultValue="8") Integer pageSize){
        List<Object> categoryVos = categoryService.selectCategoryByIdList(cid, curPage, pageSize);
        return categoryVos;
    }

    /**
     * 模糊查询其商品名字
     * @param name 商品名字
     * @return
     */
    @PostMapping("keyName")
    @ResponseBody
    public List<ProductVo> selectKeywordName(@RequestParam(required = true)String  name){
        List<ProductVo> list = productService.selectKeyName(name);
        return list;
    }


    /**
     * 根据其商品的ID 查询其商品详情信息
     * @param pid
     * @return
     */
    @PostMapping("/Details")
    public Object selectProductDetails(@RequestParam(required = true) Integer pid){
        Details_productVo product = productService.selectProductDetails(pid);
        return product;
    }


}
