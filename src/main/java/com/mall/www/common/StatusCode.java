package com.mall.www.common;

import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS(200, "success"),
    ERROR(404, "error"),
    SYS_ERROR(4000, "系统错误!!! 请稍后再试"),
    REGISTER_ERROR(4008,"用户名重复，注册失败，请重试"),
    KEY_ERROR(4009,"输入违规字符,请重试"),
    SERVER_ERROR(5000, "服务器错误");
    private int status;
    private String message;

    StatusCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
