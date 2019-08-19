package com.dhcc.csr.common.base;


import com.dhcc.csr.network.transform.ResponseTransformer;

import io.reactivex.Observable;

/**
 * @Author: wlsh
 * @Date: 2019/7/31 16:52
 * @Description: Model基类 处理异常 线程切换
 */
public class BaseModel {
    protected <T> Observable<T> observe(Observable<T> observable) {
        return observable
                .compose(ResponseTransformer.switchSchedulers())
                .compose(ResponseTransformer.handleResult());
    }
}
