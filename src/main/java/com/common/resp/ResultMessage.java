package com.common.resp;

import com.common.enums.ResultCode;
import com.common.exception.IResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 结果消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMessage implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    private String sign;

    public boolean hasError() {
        return !this.code.equals(ResultCode.SUCCESS.getCode());
    }

    public static ResultMessage success() {
        ResultMessage result = new ResultMessage();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static ResultMessage success(Object data) {
        ResultMessage result = new ResultMessage();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResultMessage success(Object data, String sign) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setResultCode(ResultCode.SUCCESS);
        resultMessage.setData(data);
        resultMessage.setSign(sign);
        return resultMessage;
    }

    public static ResultMessage failure(ResultCode resultCode) {
        ResultMessage result = new ResultMessage();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResultMessage failure(ResultCode resultCode, Object data) {
        ResultMessage result = new ResultMessage();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static ResultMessage failure(IResponseEnum responseEnum, Object data) {
        ResultMessage result = new ResultMessage();
        result.setCode(responseEnum.getCode());
        result.setMsg(responseEnum.getMessage());
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
}
