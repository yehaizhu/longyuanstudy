package com.zhuyehai.base.model;

import android.content.Context;

/**
 * Created by zhuyehai on 17/6/19.
 */

public class BasePresenter<M, T> {
    public Context context;
    public M mModel;
    public T mView;
    public void setVM(T v, M m) {
        this.mView = v;
        this.mModel = m;
    }
}
