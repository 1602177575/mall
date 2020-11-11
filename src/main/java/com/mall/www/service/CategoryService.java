package com.mall.www.service;


import com.mall.www.common.vo.CategoryVo;
import com.mall.www.common.vo.ProductVo;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface CategoryService {


    /**
     * limit  (curPage-1)*pageSize,pageSize
     * @param pid
     * @param curPage 当前第几页
     * @param pageSize 一页多少数据
     * @return
     */
    CategoryVo selectCategoryByIdList(Integer pid, Integer curPage, Integer pageSize);


    /**
     * 展示分类
     * @param value 展示前几个分类
     * @return
     */
     List<String> selectCategoryTopTile(Integer value);


    /**
     * 主页展示分类下 热销产品
     * @param cid 产品类别
     * @param value  展示前几条
     * @return
     */
     List<Object> selectCategoryTopById(Integer cid,Integer value);

}
