package com.dhcc.csr.ui.main.contact;

import com.dhcc.csr.common.base.IPresenter;
import com.dhcc.csr.common.base.IView;
import com.dhcc.csr.network.exception.ApiException;

/**
 * @Author: wlsh
 * @Date: 2019/7/18 11:47
 * @Description: 主界面契约类
 */
public class MainContactLifecycle {

    public interface MainView extends IView {
        void success(String result);

        void fail(ApiException e);
    }

    public interface MainPresenter extends IPresenter {
        void outBaseUrlTest(String loginName);
    }
}
