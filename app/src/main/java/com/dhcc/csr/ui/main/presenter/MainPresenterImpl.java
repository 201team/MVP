package com.dhcc.csr.ui.main.presenter;

import com.dhcc.csr.common.base.BaseObserver;
import com.dhcc.csr.common.base.BasePresenter;
import com.dhcc.csr.network.exception.ApiException;
import com.dhcc.csr.ui.main.contact.MainContactLifecycle;
import com.dhcc.csr.ui.main.model.MainModel;

/**
 * @Author: wlsh
 * @Date: 2019/7/18 11:51
 * @Description: 主界面P实现类
 */
public class MainPresenterImpl extends BasePresenter<MainContactLifecycle.MainView, MainModel>
        implements MainContactLifecycle.MainPresenter {


    public MainPresenterImpl(MainContactLifecycle.MainView mView, MainModel mBaseModel) {
        super(mView, mBaseModel);
    }

    /**
     * 网络请求
     *
     * @param loginName
     */
    @Override
    public void outBaseUrlTest(String loginName) {

        mBaseModel.outUrl(loginName)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    protected void onStart() {
                        mView.showLoading();
                    }

                    @Override
                    protected void onSuccess(String s) {
                        mView.success(s);
                        mView.hideLoading();
                    }

                    @Override
                    protected void onApiError(ApiException ex) {
                        mView.fail(ex);
                        mView.hideLoading();
                    }
                });
    }
}
