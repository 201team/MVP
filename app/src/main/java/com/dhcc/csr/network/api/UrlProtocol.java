package com.dhcc.csr.network.api;

/**
 * @author wlsh
 * @date 2019/1/17 13:55
 * @description 网络请求接口
 */
public interface UrlProtocol {
    String APP_DEFAULT_URL = "http://10.20.202.22:8080/Test/wrong/";

    String APP_OUT_URL = "http://10.20.202.22:8080/OutUrl/";
    String APP_MAIN_URL = "http://10.20.202.22:8080/Test/";

    String OUT_DOMAIN_NAME = "out";
    String MAIN_DOMAIN_NAME = "main";
}
