package com.dhcc.csr.network.exception;

/**
 * @Author: wlsh
 * @Date: 2019/8/2 17:30
 * @Description: 服务器内部异常
 */
public class ServerException extends RuntimeException {

    private int code;
    private String msg;

    public ServerException(int code, String msg) {
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
