package com.wll.inspection.exception;

import com.wll.inspection.enums.ResultEnum;

/**
 * @Author: clf
 * @Date: 19-1-17
 * @Description:
 * 全局异常类
 */
public class GlobalException extends RuntimeException {
    private ResultEnum codeMsg;
    private String message;
    private Integer code;

    public GlobalException(ResultEnum resultEnum) {
        super();
        this.message = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    public GlobalException(String message, Integer code) {
        super();
        this.message = message;
        this.code = code;
    }

    public ResultEnum getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(ResultEnum codeMsg) {
        this.codeMsg = codeMsg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}