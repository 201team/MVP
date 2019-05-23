package com.dhcc.csr.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.BarUtils;
import com.dhcc.csr.R;
import com.dhcc.csr.util.StatusBarUtil;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wlsh
 * @date 2019/1/16 10:47
 * @description Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity mContext;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        mContext = this;
        setContentView(getLayoutId());
        //设置状态栏颜色
        StatusBarUtil.setColor(this,ContextCompat.getColor(this, R.color.color_C60119));
        //绑定butter knife
        unbinder = ButterKnife.bind(this);
        //应用数据统计
        PushAgent.getInstance(this).onAppStart();
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
