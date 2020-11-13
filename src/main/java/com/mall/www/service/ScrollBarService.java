package com.mall.www.service;

import com.mall.www.common.bo.ScrollBarBo;
import com.mall.www.common.vo.ScrollBarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScrollBarService {


    /**
     * 查询滚动栏
     * @return
     */
    List<ScrollBarVo> selectScrollBar(@Param("value")Integer value);


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
