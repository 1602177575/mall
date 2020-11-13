package com.mall.www.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserCommentsDto implements Serializable {
    private Integer uid; //商品外键
    private Integer pid; //商品ID
    private String evaluate; //好评 差评 中评
    private String comment; //评论内容
    private String answer; //其他回复
//    private Date commentsTime; //提问时间
}
