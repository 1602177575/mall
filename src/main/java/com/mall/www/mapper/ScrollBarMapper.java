package com.mall.www.mapper;

import com.mall.www.common.bo.ScrollBarBo;
import com.mall.www.entity.ScrollBar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScrollBarMapper {

    /**
     * 查询滚动栏
     * @return
     */
    List<ScrollBarBo> selectScrollBar(@Param("value")Integer value);


    /**
     * 添加滚动栏图片
     * @return
     */
    Integer insertScrollBar(ScrollBarBo scrollBarBo);


    /**
     * 删除滚动栏
     * @param id
     * @return
     */
    Integer deleteScrollBar(Integer id);
}
