package com.mall.www.controller;


import com.mall.www.common.ResponseEntity;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.service.CategoryService;
import com.mall.www.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Response;
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
    public ResponseEntity<List<Object>> SelectCategory(@RequestParam(required=true)Integer cid, @RequestParam(defaultValue="1")Integer curPage, @RequestParam(defaultValue="8") Integer pageSize){
        return  ResponseEntity.success(categoryService.selectCategoryByIdList(cid, curPage, pageSize));
    }

    /**
     * 模糊查询其商品名字
     * @param name 商品名字
     * @return
     */
    @PostMapping("/keyName")
    public ResponseEntity<List<ProductVo> >selectKeywordName(@RequestParam(required = true,value = "name")String  name){
      return ResponseEntity.success(productService.selectKeyName(name));
    }


    /**
     * 根据其商品的ID 查询其商品详情信息
     * @param pid
     * @return
     */
    @PostMapping("/Details")
    public ResponseEntity<Object> selectProductDetails(@RequestParam(required = true) Long pid){
        return ResponseEntity.success(productService.selectProductDetails(pid));
    }


}
