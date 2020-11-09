package com.mall.www.common;

import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS(200, "success"),
    ERROR(404, "error"),
    SYS_ERROR(4000, "系统错误!!! 请稍后再试"),
    SERVER_ERROR(5000, "服务器错误");
    private int status;
    private String message;

    StatusCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
