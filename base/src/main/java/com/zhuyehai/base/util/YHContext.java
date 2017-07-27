package com.zhuyehai.base.util;

import android.content.Context;

/**
 * Created by zhuyehai on 17/7/27.
 */

public class YHContext {
    private Context context;



    private static final YHContext ourInstance = new YHContext();

    public static YHContext getInstance() {
        return ourInstance;
    }

    private YHContext() {}

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
