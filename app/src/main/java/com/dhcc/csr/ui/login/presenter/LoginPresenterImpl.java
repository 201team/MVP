package com.dhcc.csr.ui.login.presenter;

import com.blankj.utilcode.util.ObjectUtils;
import com.dhcc.csr.network.UrlProtocol;
import com.dhcc.csr.ui.login.contact.LoginContact;
import com.dhcc.csr.ui.login.model.LoginService;
import com.dhcc.csr.util.AESOperator;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
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
        final AESOperator operator = AESOperator.getInstance();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProtocol.MAIN_HOST)
                .addConverterFactory(ScalarsConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        LoginService loginService = retrofit.create(LoginService.class);
        try {
            Call<String> stringCall = loginService.loginNew(operator.encrypt(name), operator.encrypt(pass),
                    operator.encrypt(type), operator.encrypt(deviceToken));
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (ObjectUtils.isNotEmpty(mView)) {
                        mView.dismissLoginDialog();
                    }
                    if (200 == response.code()) {
                        String result = response.body();
                        try {
                            result = operator.decrypt(result);
                            Logger.d("LoginService返回:" + result);
                            if (ObjectUtils.isNotEmpty(mView)) {
                                mView.loginSuccess(result);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (ObjectUtils.isNotEmpty(mView)) {
                                mView.loginFailure();
                            }
                        }
                    } else {
                        if (ObjectUtils.isNotEmpty(mView)) {
                            mView.loginFailure();
                        }
                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Logger.d("失败了" + t.getMessage());
                    if (ObjectUtils.isNotEmpty(mView)) {
                        mView.loginFailure();
                        mView.dismissLoginDialog();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (ObjectUtils.isNotEmpty(mView)) {
                mView.loginFailure();
                mView.dismissLoginDialog();
            }
        }

    }
}
