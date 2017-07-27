package com.zhuyehai.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.zhuyehai.base.util.TUtil;
import com.zhuyehai.base.util.YHContext;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by zhuyehai on 17/6/16.
 */

public abstract class BaseActiviy<T extends BasePresenter, E> extends FragmentActivity {
    private boolean isEvent;
    private T mPresenter;
    private E mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        YHContext.getInstance().setContext(this);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) mPresenter.setVM(this, mModel);
        getData();
    }


    protected abstract void initData();

    protected abstract int  getLayoutId();

    protected abstract void getData();

    protected void registerEvenBus(boolean isRegister) {
        setEvent(isRegister);
        initEventBus();
    }

    private void initEventBus() {
        if (isEvent) {
            EventBus.getDefault().unregister(this);
        }
    }

    private void setEvent(boolean isEvent) {
        this.isEvent = isEvent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isEvent) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        YHContext.getInstance().setContext(this);
    }
}
