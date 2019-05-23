package com.dhcc.csr.common;

import android.app.Application;
import android.support.annotation.Nullable;

import com.coder.zzq.smartshow.core.SmartShow;
import com.coder.zzq.smartshow.snackbar.SmartSnackbar;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.coder.zzq.smartshow.topbar.SmartTopbar;
import com.dhcc.csr.BuildConfig;
import com.dhcc.csr.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;


/**
 * @author wlsh
 * @date 2019/1/16 12:29
 * @description Application
 */
public class App extends Application {
    private static String TAG = "njcsrAndroid";

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        initUM();
        initSmartShow();
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


    /**
     * 友盟推送初始化
     */
    private void initUM() {
        // 参数一：当前上下文context；
        // 参数二：应用申请的Appkey（需替换）；
        // 参数三：渠道名称；
        // 参数四：设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机；
        UMConfigure.init(this, "58f5774baed1797b48001d16",
                "dhcc", UMConfigure.DEVICE_TYPE_PHONE, "9ca48e344e82bad9986bb1a59c1ee3c3");
        //注册推送服务
        PushAgent pushAgent = PushAgent.getInstance(this);
        pushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String s) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Logger.d("注册成功：deviceToken：-------->  " + s);
            }

            @Override
            public void onFailure(String s, String s1) {
                Logger.e("注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });
    }
}
