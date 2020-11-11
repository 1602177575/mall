package com.mall.www.controller;


import com.mall.www.common.ResponseEntity;
import com.mall.www.common.vo.CategoryVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.service.CategoryService;
import com.mall.www.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类
 * 查看分类下商品数据
 * 模糊查询商品名字
 * 商品下的排序
 */
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
    @RequestMapping(value = "/category/{ids}/{p}")
    public ResponseEntity<CategoryVo> SelectCategory(@PathVariable(value = "ids",required=true) Integer cid, @PathVariable(value = "p")  Integer curPage, @RequestParam(defaultValue="8") Integer pageSize){
        return  ResponseEntity.success(categoryService.selectCategoryByIdList(cid, curPage, pageSize));
    }

    /**
     * 模糊查询其商品名字
     * @param name 商品名字
     * @return
     */
    @PostMapping("/key")
    public ResponseEntity<List<ProductVo> >selectKeywordName(@RequestParam(required = true,value = "name")String  name){
      return ResponseEntity.success(productService.selectKeyName(name));
    }




}
