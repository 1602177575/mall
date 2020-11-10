package com.mall.www.entity;

import lombok.Data;

@Data
public class Details {
    /**
     *
     */
    private Integer id;

    /**
     * 对应商品ID
     */
    private Integer pid;

    /**
     * 包装清单
     */
    private String packing;

    /**
     * 主体信息
     */
    private String subject;

    /**
     * 外观
     */
    private String facade;

    /**
     * 系统参数
     */
    private String system;

    /**
     * cpu核心参数
     */
    private String cpu;

    /**
     * 网络参数
     */
    private String notwork;

    /**
     * 储存
     */
    private String stockpile;

    /**
     * 屏幕参数
     */
    private String screen;
}

