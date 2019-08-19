package com.dhcc.csr.network.interceptor;

import com.dhcc.csr.network.config.BaseRetrofitConfig;
import com.dhcc.csr.util.ChineseJudgeUtil;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: wlsh
 * @Date: 2019/8/12 8:51
 * @Description: 添加Header
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获得请求实例
        Request request = chain.request();
        //获取请求体
        FormBody formBody = (FormBody) request.body();
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (formBody != null && formBody.size() > 0) {
            for (int i = 0; i < formBody.size(); i++) {
                //把原来的参数添加到新的构造器
                formBodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
            }
        }
        //构造新的请求体
        formBody = formBodyBuilder
                .build();
        //统一头部配置
        Map<String, String> configMap = BaseRetrofitConfig.getOriginalHeaders();
        Request.Builder requestBuilder = request.newBuilder();
        if (configMap != null && configMap.size() > 0) {
            Set<String> keySets = configMap.keySet();
            for (String headerKey : keySets) {
                //中文进行转码
                String headerValue = configMap.get(headerKey);
                if (ChineseJudgeUtil.isChinese(headerValue)) {
                    requestBuilder.addHeader(headerKey, URLEncoder.encode(headerValue, "UTF-8"));
                } else {
                    requestBuilder.addHeader(headerKey, headerValue);
                }
            }
        }
        request = requestBuilder
                //添加新参数后的请求体
                .post(formBody)
                .build();
        //继续发送原始请求
        return chain.proceed(request);
    }
}
