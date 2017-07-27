package com.zhuyehai.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuyehai.base.util.TUtil;

import butterknife.ButterKnife;

/**
 * Created by zhuyehai on 17/6/19.
 */

public abstract class BaseFragment<T extends BasePresenter, E> extends Fragment {
    private View rootView;
    private T mPresenter;
    private E mModel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();

        rootView = inflater.inflate(getLayoutId(), container, false);
        if(rootView!=null){
            ButterKnife.bind(this,rootView);
            mPresenter = TUtil.getT(this, 0);
            mModel = TUtil.getT(this, 1);
            if (this instanceof BaseView) mPresenter.setVM(this, mModel);
            getData();
            return rootView;
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void initData();

    protected abstract int getLayoutId();

    protected abstract void getData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
