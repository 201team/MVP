package com.dhcc.csr.network.exception;

/**
 * @Author: wlsh
 * @Date: 2019/8/3 13:15
 * @Description: 约定异常
 */
public class ERROR {
    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR = 1002;
    /**
     * 协议出错
     */
    public static final int HTTP_ERROR = 1003;
    /**
     * 证书出错
     */
    public static final int SSL_ERROR = 1005;
    /**
     * 服务器内部异常
     */
    public static final int SERVER_INTERNAL_ERROR = 1006;
    /**
     * Token过期
     */
    public static final int TOKEN_ERROR = 1007;
}