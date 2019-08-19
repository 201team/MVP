package com.dhcc.csr.common.base;

import com.dhcc.csr.network.bean.RespEntity;
import com.dhcc.csr.network.exception.ApiException;
import com.dhcc.csr.network.exception.ERROR;
import com.dhcc.csr.network.exception.ServerException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Author: wlsh
 * @Date: 2019/8/2 22:45
 * @Description: 处理结果
 */
public abstract class BaseObserver<T> implements Observer<RespEntity<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        onStart();
    }

    @Override
    public void onNext(RespEntity<T> tRespEntity) {
        if (200 == tRespEntity.getStatus()) {
            onSuccess(tRespEntity.getData());
        } else {
            //服务器内部异常
            ApiException apiException = new ApiException(
                    new ServerException(ERROR.SERVER_INTERNAL_ERROR, tRespEntity.getMsg()),
                    ERROR.SERVER_INTERNAL_ERROR);
            apiException.setDisplayMessage(tRespEntity.getMsg());
            onApiError(apiException);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            onApiError((ApiException) e);
        } else {
            //转为未知异常
            ApiException apiException = new ApiException(e, ERROR.UNKNOWN);
            apiException.setDisplayMessage("未知错误");
            onApiError(apiException);
        }
    }

    @Override
    public void onComplete() {

    }

    /**
     * 开始
     */
    protected abstract void onStart();


    /**
     * 返回成功
     *
     * @param t
     */
    protected abstract void onSuccess(T t);


    /**
     * 错误回调
     */
    protected abstract void onApiError(ApiException ex);

}
