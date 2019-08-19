package com.dhcc.csr.common;

import android.app.Application;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.SPStaticUtils;
import com.blankj.utilcode.util.SPUtils;
import com.coder.zzq.smartshow.core.SmartShow;
import com.coder.zzq.smartshow.snackbar.SmartSnackbar;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.coder.zzq.smartshow.topbar.SmartTopbar;
import com.dhcc.csr.BuildConfig;
import com.dhcc.csr.R;
import com.dhcc.csr.common.base.Constants;
import com.dhcc.csr.network.RxRetrofitManager;
import com.dhcc.csr.network.api.UrlProtocol;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


/**
 * @author wlsh
 * @date 2019/1/16 12:29
 * @description Application
 */
public class App extends Application {
    private static String TAG = "njcsr";

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        initSmartShow();
        //初始化Retrofit OkHttp等配置信息
        RxRetrofitManager.getInstance().init();
        //使用超级模式
        RetrofitUrlManager.getInstance().putDomain(UrlProtocol.OUT_DOMAIN_NAME, UrlProtocol.APP_OUT_URL);
        RetrofitUrlManager.getInstance().putDomain(UrlProtocol.MAIN_DOMAIN_NAME, UrlProtocol.APP_MAIN_URL);
    }

    /**
     * 初始化SmartShow
     */
    private void initSmartShow() {
        SmartShow.init(this);
        SmartToast.globalSetting()
                .dismissOnLeave(false);

        SmartSnackbar.setting()
                .backgroundColorRes(R.color.colorPrimary)
                .dismissOnLeave(true);

        SmartTopbar.setting()
                .msgTextColorRes(R.color.color_FFFFFF)
                .actionColorRes(R.color.colorAccent)
                .dismissOnLeave(true);
    }

    /**
     * 初始化Logger库
     */
    private void initLogger() {

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(TAG)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                //控制log输出
                return BuildConfig.DEBUG;
            }
        });
    }
}
