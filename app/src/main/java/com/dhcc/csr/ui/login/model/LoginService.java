package com.dhcc.csr.ui.login.model;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author wlsh
 * @date 2019/1/23 14:25
 * @description 登录接口
 */
public interface LoginService {

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
}
