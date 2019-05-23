package com.dhcc.csr.ui.main;

import android.content.res.Resources;
import android.os.Bundle;

import com.blankj.utilcode.util.AdaptScreenUtils;
import com.dhcc.csr.R;
import com.dhcc.csr.common.base.BaseActivity;

/**
 * @author wlsh
 * @date 2019/1/16 13:35
 * @description 主界面
 */
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public Resources getResources() {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 1080);
    }
}
