package com.dhcc.csr.network.api;

import com.dhcc.csr.bean.VisitObject;
import com.dhcc.csr.network.bean.RespEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * @author wlsh
 * @date 2019/1/23 14:25
 * @description 登录接口
 */
public interface BaseApi {

    @GET("MobileLogin")
    Call<String> login(@Query("userId") String userId, @Query("ps") String ps,
                       @Query("type") String type, @Query("deviceToken") String deviceToken);

    @FormUrlEncoded
    @POST("MobileLogin")
    Call<String> loginNew(@Field("userId") String userId, @Field("ps") String ps,
                          @Field("type") String type, @Field("deviceToken") String deviceToken);

    @FormUrlEncoded
    @POST("MobileLogin")
    Observable<String> loginObservable(@Field("userId") String userId, @Field("ps") String ps,
                                       @Field("type") String type, @Field("deviceToken") String deviceToken);

    @Headers({RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlProtocol.MAIN_DOMAIN_NAME})
    @FormUrlEncoded
    @POST("MobileLogin" + RetrofitUrlManager.IDENTIFICATION_PATH_SIZE + 2)
    Observable<RespEntity<ArrayList<VisitObject>>> rxLogin(
            @Field("userId") String userId, @Field("ps") String ps,
            @Field("type") String type, @Field("deviceToken") String deviceToken
    );

    /**
     * 在 Url 的尾部加上 {@link RetrofitUrlManager#IDENTIFICATION_PATH_SIZE} + PathSize, 表示此 Url 使用超级模式
     * {@link RetrofitUrlManager#IDENTIFICATION_PATH_SIZE} + 2
     * 表示此 Url 中需要被替换的 BaseUrl 为 '域名/api/data', 它的 PathSize 等于 2
     */
    @Headers({RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlProtocol.OUT_DOMAIN_NAME})
    @FormUrlEncoded
    @POST("OutUrl" + RetrofitUrlManager.IDENTIFICATION_PATH_SIZE + 2)
    Observable<RespEntity<String>> outUrl(@Field("loginName") String loginName);

    @Headers({RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlProtocol.MAIN_DOMAIN_NAME})
    @FormUrlEncoded
    @POST("GetToken" + RetrofitUrlManager.IDENTIFICATION_PATH_SIZE + 2)
    Call<ResponseBody> getToken(
            @Field("userId") String userId, @Field("ps") String ps,
            @Field("type") String type, @Field("deviceToken") String deviceToken
    );
}
