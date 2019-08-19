package com.dhcc.csr.ui.login.model;

import com.dhcc.csr.bean.VisitObject;
import com.dhcc.csr.common.base.BaseModel;
import com.dhcc.csr.network.RxRetrofitManager;
import com.dhcc.csr.network.api.BaseApi;
import com.dhcc.csr.network.bean.RespEntity;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * @Author: wlsh
 * @Date: 2019/7/31 16:48
 * @Description: 登录
 */
public class LoginModel extends BaseModel {
    /**
     * @param name        工号
     * @param pass        密码
     * @param type        类型 1 Android 2 Ios
     * @param deviceToken 设备令牌
     * @return
     */
    public Observable<RespEntity<ArrayList<VisitObject>>> login(String name, String pass, String type, String deviceToken) {
        BaseApi baseApi = RxRetrofitManager.getInstance().create(BaseApi.class);
        return observe(baseApi.rxLogin(name, pass, type, deviceToken));
    }
}
