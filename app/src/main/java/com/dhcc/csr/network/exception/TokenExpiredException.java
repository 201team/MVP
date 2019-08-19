package com.dhcc.csr.network.exception;

/**
 * @Author: wlsh
 * @Date: 2019/8/12 17:26
 * @Description: token过期异常
 */
public class TokenExpiredException extends RuntimeException {
    private int code;
    private String msg;

    public TokenExpiredException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
