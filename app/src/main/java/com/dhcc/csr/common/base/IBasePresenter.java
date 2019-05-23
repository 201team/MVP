package com.dhcc.csr.common.base;

/**
 * @author wlsh
 * @date 2019/1/17 15:41
 * @description Presenter基类
 */
public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);

    void detachView();
}
