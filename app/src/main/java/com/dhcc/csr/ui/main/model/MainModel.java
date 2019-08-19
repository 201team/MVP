package com.dhcc.csr.ui.main.model;

import com.dhcc.csr.common.base.BaseModel;
import com.dhcc.csr.network.RxRetrofitManager;
import com.dhcc.csr.network.api.BaseApi;
import com.dhcc.csr.network.bean.RespEntity;

import io.reactivex.Observable;

/**
 * @Author: wlsh
 * @Date: 2019/8/1 10:21
 * @Description: 主界面的外部Url
 */
public class MainModel extends BaseModel {
    public Observable<RespEntity<String>> outUrl(String loginName) {
        BaseApi baseApi = RxRetrofitManager.getInstance().create(BaseApi.class);
        return observe(baseApi.outUrl(loginName));
    }
}
