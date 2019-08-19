package com.dhcc.csr.common.base;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

/**
 * @Author: wlsh
 * @Date: 2019/8/5 17:28
 * @Description: BasePresenter
 */
public class BasePresenter<V extends IView, M extends BaseModel> implements IPresenter {

    protected V mView;
    protected M mBaseModel;
    protected LifecycleOwner lifecycleOwner;


    public BasePresenter(@NonNull V mView, @NonNull M mBaseModel) {
        this.mView = mView;
        this.mBaseModel = mBaseModel;
    }

    @Override
    public void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Logger.d("onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Logger.d("onStart");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Logger.d("onResume");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Logger.d("onPause");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Logger.d("onStop");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Logger.d("onDestroy");
        this.mView = null;
        this.mBaseModel = null;
    }
}
