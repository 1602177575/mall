package com.mall.www.exception;

import com.mall.www.common.StatusCode;
import lombok.Data;
import lombok.Getter;

@Getter
public class ServiceException extends BaseException {
    public ServiceException(StatusCode statusCode) {
        super(statusCode);
    }
}
