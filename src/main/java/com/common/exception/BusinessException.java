package com.common.exception;

import com.common.enums.ResultCode;
import lombok.Getter;

/**
 * 业务异常包装类
 */
@Getter
public class BusinessException extends RuntimeException {
    private ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
