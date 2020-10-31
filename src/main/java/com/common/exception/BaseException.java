package com.common.exception;


import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private IResponseEnum responseEnum;
    private String msg;

    public BaseException(IResponseEnum responseEnum, Object[] args, String msg) {
        this.responseEnum = responseEnum;
        this.msg = msg;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String msg, Throwable cause) {
        this.responseEnum = responseEnum;
        this.msg = msg;
    }
}
