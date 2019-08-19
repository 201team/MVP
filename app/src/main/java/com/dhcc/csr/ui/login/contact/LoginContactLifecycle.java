package com.dhcc.csr.ui.login.contact;

import com.dhcc.csr.bean.VisitObject;
import com.dhcc.csr.common.base.IPresenter;
import com.dhcc.csr.common.base.IView;
import com.dhcc.csr.network.exception.ApiException;

import java.util.ArrayList;

/**
 * @Author: wlsh
 * @Date: 2019/8/6 18:15
 * @Description: Lifecycle契约类
 */
public class LoginContactLifecycle {

    public interface LoginView extends IView {
        void loginSuccess(ArrayList<VisitObject> result);

        void loginFailure(ApiException e);

        void memoryTest(Long number);
    }

    public interface LoginPresenter extends IPresenter {
        void login(String name, String pass, String type, String deviceToken);
    }
}
