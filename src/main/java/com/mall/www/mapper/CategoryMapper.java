package com.mall.www.mapper;

import com.mall.www.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CategoryMapper {


    /**
     *  根据产品ID  查询指定分类下的全部产品
     * @param pid
     * @return
     */
    List<Product> selectCategoryById(@Param("pid") Integer pid);

    /**
     * 根据分类名 查询分类的ID
     * @param name
     * @return
     */
    Integer selectCategoryIDByName(@Param("pName") String name);

    /**
     * 分类查询 分类产品
     *
     * curPage 当前第几页
     * pageSize 一页多少数据
     *  limit  (curPage-1)*pageSize,pageSize
     * @param pid
     * @return
     */
    List<Product> selectCategoryList(@Param("pid") Integer pid,@Param("curPage")Integer curPage,@Param("pageSize")Integer pageSize);


    /**
     * 查询前几条分类的名字
     * @param value
     * @return
     */
    List<String> selectCategoryTopName(@Param("value") Integer value);


    /**
     * 展示分类下的热销产品
     * @return
     */
    List<Product> selectCategoryTopById(@Param("cid") Integer cid,@Param("value") Integer value);
}
