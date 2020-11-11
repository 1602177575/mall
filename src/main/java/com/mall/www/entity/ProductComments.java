package com.mall.www.entity;

import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductComments {
    /**
     *
     */
    private Integer id;

    /**
     * 商品外键
     */
    private Integer pid;

    /**
     * 用户外键
     */
    private Integer uid;

    /**
     * 用户提问
     */
    private String issue;

    /**
     * 商家答复
     */
    private String answer;

    /**
     * 提问回答时间
     */
    private Date commentsTime;
}

