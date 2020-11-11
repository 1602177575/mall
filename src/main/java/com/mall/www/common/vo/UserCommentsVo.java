package com.mall.www.common.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserCommentsVo {

    private String evaluate; //好评 差评 中评
    private String comment; //评论内容
    private String answer; //其他回复
    private Date commentsTime; //提问时间
}
