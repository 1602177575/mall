package com.mall.www.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Mailbox {
    /**
     * 主键
     */
    private Long mailboxId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发件人
     */
    private String addresser;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 邮箱状态：0->正常，1->被删除到垃圾箱
     */
    private Integer mailboxStatus;

    /**
     * 状态：0->未读，1->已读
     */
    private Integer status;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

