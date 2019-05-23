package com.dhcc.csr.common.base;

import android.content.Context;
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
 * @description MVP模式Fragment抽象类
 */
public abstract class MvpBaseFragment<V extends IBaseView, T extends IBasePresenter<V>> extends Fragment implements IBaseView {

    protected T mPresenter;
    protected Unbinder unbinder;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.attachView((V) this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解除绑定
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Nullable
    @Override
    public Context getContext() {
        return mContext;
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
