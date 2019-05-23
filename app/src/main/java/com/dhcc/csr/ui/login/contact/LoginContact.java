package com.dhcc.csr.ui.login.contact;

import com.dhcc.csr.common.base.IBasePresenter;
import com.dhcc.csr.common.base.IBaseView;

/**
 * @author wlsh
 * @date 2019/1/17 17:36
 * @description 登陆契约类
 */
public class LoginContact {
    public interface LoginView extends IBaseView {

        void loginSuccess(String result);

        void loginFailure();

        void showLoginDialog();

        void dismissLoginDialog();
    }

    public interface LoginPresenter extends IBasePresenter<LoginView> {
        void login(String name, String pass, String type, String deviceToken);
    }
}
