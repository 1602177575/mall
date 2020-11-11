package com.mall.www.service;

import com.mall.www.common.vo.HomeVo;
import org.springframework.stereotype.Service;

@Service
public interface HomeService {
    /**
     * 传递主页需要的数据
     * @param tile 多少条标题
     * @param num 前三分类多少条数据
     * @return
     */
    public HomeVo selectHome(Integer tile,Integer num);

}
