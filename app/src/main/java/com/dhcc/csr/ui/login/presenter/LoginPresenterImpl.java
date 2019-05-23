package com.dhcc.csr.ui.login.presenter;

import com.blankj.utilcode.util.ObjectUtils;
import com.dhcc.csr.network.UrlProtocol;
import com.dhcc.csr.ui.login.contact.LoginContact;
import com.dhcc.csr.ui.login.model.LoginService;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author wlsh
 * @date 2019/1/18 17:06
 * @description 登录presenter的实现类
 */
public class LoginPresenterImpl implements LoginContact.LoginPresenter {

    private LoginContact.LoginView mView;

    @Override
    public void attachView(LoginContact.LoginView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void login(String name, String pass, String type, String deviceToken) {

        if (ObjectUtils.isNotEmpty(mView)) {
            mView.showLoginDialog();
        }

        Logger.d("登陆参数:" + name + "," + pass + "," + type + "," + deviceToken);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProtocol.MAIN_HOST)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        LoginService loginService = retrofit.create(LoginService.class);
        Observable<String> observable = loginService.loginObservable(name, pass, type, deviceToken);
        //通过Observable发起请求
        observable
                .subscribeOn(Schedulers.io())//指定网络请求在io后台线程中进行
                .observeOn(AndroidSchedulers.mainThread())//指定observer回调在UI主线程中进行
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Logger.d("onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Logger.d("onNext" + s);
                        if (ObjectUtils.isNotEmpty(mView)) {
                            mView.loginSuccess(s);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("onError" + e.getMessage());
                        if (ObjectUtils.isNotEmpty(mView)) {
                            mView.loginFailure();
                            mView.dismissLoginDialog();
                        }
                    }

                    @Override
                    public void onComplete() {
                        Logger.d("onComplete");
                    }
                });

//        Call<String> stringCall = loginService.loginNew(name, pass, type, deviceToken);
//        stringCall.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (ObjectUtils.isNotEmpty(mView)) {
//                    mView.dismissLoginDialog();
//                }
//                if (200 == response.code()) {
//                    String result = response.body();
//                    Logger.d("LoginService返回:" + result);
//                    if (ObjectUtils.isNotEmpty(mView)) {
//                        mView.loginSuccess(result);
//                    }
//                } else {
//                    if (ObjectUtils.isNotEmpty(mView)) {
//                        mView.loginFailure();
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Logger.d("失败了" + t.getMessage());
//                if (ObjectUtils.isNotEmpty(mView)) {
//                    mView.loginFailure();
//                    mView.dismissLoginDialog();
//                }
//            }
//        });
    }

}
