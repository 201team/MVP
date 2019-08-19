package com.dhcc.csr.network.interceptor;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPStaticUtils;
import com.dhcc.csr.bean.TokenEntity;
import com.dhcc.csr.common.base.Constants;
import com.dhcc.csr.common.base.ErrorCode;
import com.dhcc.csr.network.RxRetrofitManager;
import com.dhcc.csr.network.api.BaseApi;
import com.dhcc.csr.network.bean.RespEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Call;

/**
 * @Author: wlsh
 * @Date: 2019/8/12 9:16
 * @Description: 拦截Token过期错误并刷新
 */
public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获得请求实例
        Request request = chain.request();
        //获取响应体
        Response response = chain.proceed(request);

        //根据和服务端的约定判断token过期
        if (isTokenExpired(response)) {
            Logger.d("自动刷新Token,然后重新请求数据");
            //同步请求方式，获取最新的Token
            String headerToken = request.header("Token");
            String newToken = getNewToken(headerToken);
            Logger.d("新的Token:" + newToken);
            //使用新的Token，创建新的请求
            Request newRequest = request
                    .newBuilder()
                    .header("Token", newToken)
                    .build();
            //重新请求
            return chain.proceed(newRequest);
        }
        return response;
    }

    /**
     * 根据Response，判断Token是否失效
     *
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        String bodyString = getResponseBody(response.body());
        Gson gson = new Gson();
        Type type = new TypeToken<RespEntity>() {
        }.getType();
        RespEntity token = gson.fromJson(bodyString, type);
        Logger.d("RespEntity:" + gson.toJson(token));
        return ErrorCode.TOKEN_EXPIRED == token.getStatus();
    }

    /**
     * 同步请求方式，获取最新的Token
     *
     * @param headerToken
     */
    private synchronized String getNewToken(String headerToken) {
        //通过获取token的接口，同步请求接口
        if (SPStaticUtils.getString(Constants.LOGIN_TOKEN).equals(headerToken)) {
            Call<ResponseBody> responseBodyCall = RxRetrofitManager.getInstance().create(BaseApi.class)
                    .getToken("010700010403", "Csr.1234", "1", "AsJfxUBOo7O9CDPJpxCvLY-3qM9OZSlU2V2tN8oEJbD9");
            try {
                String result = getResponseBody(responseBodyCall.execute().body());
                Gson gson = new Gson();
                Type type = new TypeToken<RespEntity<TokenEntity>>() {
                }.getType();
                RespEntity<TokenEntity> token = gson.fromJson(result, type);
                TokenEntity tokenEntity = token.getData();
                Logger.d("返回token:" + GsonUtils.toJson(tokenEntity));
                SPStaticUtils.put(Constants.LOGIN_TOKEN, tokenEntity.getToken());
                return SPStaticUtils.getString(Constants.LOGIN_TOKEN);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /**
     * ResponseBody转为string
     *
     * @param responseBody
     * @return
     */
    private String getResponseBody(ResponseBody responseBody) {
        try {
            Charset UTF8 = Charset.forName("UTF-8");
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            //获取响应体的字符串
            String bodyString = buffer.clone().readString(charset);
            Logger.d("body---------->" + bodyString);
            return bodyString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
