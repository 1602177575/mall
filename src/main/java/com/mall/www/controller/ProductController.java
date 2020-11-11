package com.mall.www.controller;


import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.ProductCommentsDto;
import com.mall.www.common.dto.UserCommentsDto;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.common.vo.UserCommentsVo;
import com.mall.www.service.ProductCommentsService;
import com.mall.www.service.ProductService;
import com.mall.www.service.UserCommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 展示产品详情数据
 *
 *  默认传递产品数据和参数数据
 *  查看用户对其的评价
 *  查看商品的咨询
 *  用户添加评论
 *  用户咨询 商家答复
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;
    @Resource
    UserCommentsService userCommentsService;
    @Resource
    ProductCommentsService productCommentsService;

    /**
     * 展示商品详情
     * @param pid 商品ID
     * @return
     */
    @RequestMapping("/Details")
    public ResponseEntity<DetailsProductVo> selectProductDetails(@RequestParam(required = true) Long pid){
        return ResponseEntity.success(productService.selectProductDetails(pid));
    }


    /**
     * 根据商品ID 查询该商品的商品咨询
     * @param pid
     * @return
     */
    @PostMapping("/proComments")
    public ResponseEntity<List<ProductCommentsVo>> selectProCommentsByPid(Long pid){
        return ResponseEntity.success(productCommentsService.selectProductCommentsByPro(pid));
    }


    /**
     * 根据用户ID 和商品ID 创建咨询内容
     * 创建商品咨询
     * @param productCommentsDto
     * @return
     */
    @PostMapping("/addComments")
    public ResponseEntity<Integer> insertProComments(ProductCommentsDto productCommentsDto){
        return ResponseEntity.success(productCommentsService.insertProductComments(productCommentsDto));
    }




}
