package com.zhuyehai.base.common;

import android.content.Context;

import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.List;

/**
 * Created by zhuyehai on 17/6/19.
 */

public abstract class YHCommonAdapter<T> extends CommonAdapter<T> {

    public YHCommonAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
    }
    public void updateData(List<T> dataBeen) {
        if (null != dataBeen) {
            mDatas.clear();
            mDatas.addAll(dataBeen);
            notifyDataSetChanged();
        }
    }

}
