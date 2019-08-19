package com.dhcc.csr.network;

import com.dhcc.csr.BuildConfig;
import com.dhcc.csr.network.api.UrlProtocol;
import com.dhcc.csr.network.interceptor.HeaderInterceptor;
import com.dhcc.csr.network.interceptor.TokenInterceptor;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author: wlsh
 * @Date: 2019/7/30 20:40
 * @Description: Retrofit工具类
 */
public class RxRetrofitManager {

    private volatile static RxRetrofitManager mInstance;
    private OkHttpClient mOkHttpClient;
    private Retrofit retrofit;


    private RxRetrofitManager() {
    }

    /**
     * 初始化配置
     */
    public void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //打印所有okhttp请求日志
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //添加网络拦截器及Log
            builder.addInterceptor(interceptor);
        }

        //初始化OkHttp
        //RetrofitUrlManager初始化
        //RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder())
        mOkHttpClient = RetrofitUrlManager.getInstance()
                .with(builder)
                //添加header拦截器
                .addInterceptor(new HeaderInterceptor())
                //添加token拦截器
                .addInterceptor(new TokenInterceptor())
                .retryOnConnectionFailure(true) //当失败时重复请求
                .connectTimeout(10, TimeUnit.SECONDS)//连接超时时间
                .writeTimeout(20, TimeUnit.SECONDS)//写入超时
                .readTimeout(20, TimeUnit.SECONDS)//读写超时
                .build();

        //初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlProtocol.APP_DEFAULT_URL)
                .client(mOkHttpClient)
                //支持Gson
                .addConverterFactory(GsonConverterFactory.create())
                //字符串
                .addConverterFactory(ScalarsConverterFactory.create())
                //支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 双重检查加锁
     *
     * @return
     */
    public static RxRetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RxRetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RxRetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * Retrofit创建的接口代理类
     *
     * @param service 代理接口
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        Logger.d("okhttp:" + mOkHttpClient + ",retrofit:" + retrofit);
        return retrofit.create(service);
    }


    /**
     * 根据Response，判断Token是否失效
     *
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        return false;
    }


    /**
     * 同步请求方式，获取最新的Token
     *
     * @return
     */
    private String getNewToken() {
        // 通过获取token的接口，同步请求接口
        return "newToken";
    }

}
