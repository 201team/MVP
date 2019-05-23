package com.dhcc.csr.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
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
 * @description Fragment抽象类
 */
public abstract class BaseFragment extends Fragment {

    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mContextView = inflater.inflate(getLayoutId(), container, false);
        //绑定butter knife
        unbinder = ButterKnife.bind(this, mContextView);
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
}
