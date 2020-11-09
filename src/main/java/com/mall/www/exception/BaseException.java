package com.mall.www.exception;

import com.mall.www.common.StatusCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseException extends RuntimeException {
    private int status;
    private String msg;

    public BaseException(StatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.msg = statusCode.getMsg();
    }
}