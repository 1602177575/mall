package com.mall.www.common.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserCommentsVo {
    private String evaluate; //好评 差评 中评
    private String content; //评论内容
    private String answer; //其他回复
    private Date commentsTime; //提问时间
}
