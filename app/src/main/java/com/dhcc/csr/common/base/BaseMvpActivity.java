package com.dhcc.csr.common.base;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.dhcc.csr.R;
import com.dhcc.csr.util.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wlsh
 * @date 2019/1/16 10:47
 * @description MVP模式的Activity基类
 */
public abstract class BaseMvpActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        setContentView(getLayoutId());
        //设置状态栏颜色
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_C60119));
        //绑定butter knife
        unbinder = ButterKnife.bind(this);
        //绑定presenter
        mPresenter = initPresenter();
        initLifecycleObserver(getLifecycle());
        initView(savedInstanceState);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
