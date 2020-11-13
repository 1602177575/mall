package com.mall.www.common.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductCommentsDto implements Serializable {
    private Integer pid; //商品ID
    private Integer uid; //用户ID
    private String issue; //用户的提问
    private String answer; //商家答复
    private Date commentsTime; //提问回答时间
}
