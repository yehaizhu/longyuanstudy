package com.longyuan.study.longyuanstudy.ui.net;

import com.zhuyehai.base.net.RetrofitUtil;

/**
 *
 *
 */
public class ApiWrapper extends RetrofitUtil {

    private static ApiWrapper apiWrapper = null;

    public static ApiWrapper build() {
        if (apiWrapper == null)
            apiWrapper = new ApiWrapper();
        return apiWrapper;
    }
}