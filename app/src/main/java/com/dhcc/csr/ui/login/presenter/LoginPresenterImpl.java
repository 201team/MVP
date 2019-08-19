package com.dhcc.csr.ui.login.presenter;

import com.dhcc.csr.bean.VisitObject;
import com.dhcc.csr.common.base.BaseObserver;
import com.dhcc.csr.common.base.BasePresenter;
import com.dhcc.csr.common.base.ErrorCode;
import com.dhcc.csr.network.bean.RespEntity;
import com.dhcc.csr.network.exception.ApiException;
import com.dhcc.csr.network.exception.TokenExpiredException;
import com.dhcc.csr.ui.login.contact.LoginContactLifecycle;
import com.dhcc.csr.ui.login.model.LoginModel;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author wlsh
 * @date 2019/1/18 17:06
 * @description 登录presenter的实现类
 */
public class LoginPresenterImpl extends BasePresenter<LoginContactLifecycle.LoginView, LoginModel> implements LoginContactLifecycle.LoginPresenter {


    public LoginPresenterImpl(LoginContactLifecycle.LoginView mView, LoginModel mBaseModel) {
        super(mView, mBaseModel);
    }

    @Override
    public void login(String name, String pass, String type, String deviceToken) {
        Logger.d("登陆参数:" + name + "," + pass + "," + type + "," + deviceToken);
//        //测试内存泄漏
//        Observable.interval(1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Logger.d("onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Logger.d("onNext:" + aLong);
//                        mView.memoryTest(aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Logger.d("onError:" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Logger.d("onComplete");
//                    }
//                });


        mBaseModel.login(name, pass, type, deviceToken)
                .subscribe(new BaseObserver<ArrayList<VisitObject>>() {
                    @Override
                    protected void onStart() {
                        mView.showLoading();
                    }

                    @Override
                    protected void onSuccess(ArrayList<VisitObject> visitObjects) {
                        mView.loginSuccess(visitObjects);
                        mView.hideLoading();
                    }

                    @Override
                    protected void onApiError(ApiException ex) {
                        mView.loginFailure(ex);
                        mView.hideLoading();
                    }
                });
    }

}
