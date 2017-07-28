package com.zhuyehai.base.net;

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