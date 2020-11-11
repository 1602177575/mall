package com.mall.www.common.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCommentsVo {
    private Integer uid; //用户外键
    private String issue; //用户提问
    private String answer; //商家答复
    private Date commentsTime; //提问回答时间
}
