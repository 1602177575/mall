package com.mall.www.entity;

import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserComments {
    /**
     *
     */
    private Integer id;

    /**
     * 用户外键
     */
    private Integer uid;

    /**
     * 商品外键
     */
    private Integer pid;

    /**
     * 好评 差评 中评
     */
    private String evaluate;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 其他回复
     */
    private String answer;

    /**
     * 提问时间
     */
    private Date commentsTime;
}

