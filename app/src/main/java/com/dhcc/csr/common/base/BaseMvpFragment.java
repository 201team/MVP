package com.dhcc.csr.common.base;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wlsh
 * @date 2019/1/16 11:19
 * @description MVP模式Fragment抽象类
 */
public abstract class BaseMvpFragment<T extends IPresenter> extends Fragment {

    protected T mPresenter;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mContextView = inflater.inflate(getLayoutId(), container, false);
        //绑定butter knife
        unbinder = ButterKnife.bind(this, mContextView);
        //实例化Presenter
        mPresenter = initPresenter();
        initLifecycleObserver(getLifecycle());
        initView(savedInstanceState);
        initData();
        return mContextView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解除绑定
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /**
     * 初始Lifecycle
     *
     * @param lifecycle
     */
    @MainThread
    protected void initLifecycleObserver(@NonNull Lifecycle lifecycle) {
        mPresenter.setLifecycleOwner(this);
        lifecycle.addObserver(mPresenter);
    }

    /**
     * 设置布局ID
     *
     * @return 资源文件ID
     */
    protected abstract @LayoutRes
    int getLayoutId();

    /**
     * 初始化View
     *
     * @param savedInstanceState aty销毁时保存的临时参数
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据源
     */
    protected abstract void initData();

    /**
     * 创建presenter
     */
    protected abstract T initPresenter();
}
