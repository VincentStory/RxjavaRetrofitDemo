package com.example.rxjava.rxhttp;


import com.example.rxjava.http.HttpConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/4/23 5:53 PM
 * desc   :
 */

public class MRequest<R extends MRequest> {

    private static Map<String, Object> params;

    public MRequest() {
        params = new HashMap<>();
    }

    public static Map<String, Object> getParams() {
        return params;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, String value) {
        params.put(key, value);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, int value) {
        params.put(key, value);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, float value) {
        params.put(key, value);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, double value) {
        params.put(key, value);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, long value) {
        params.put(key, value);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, boolean value) {
        params.put(key, value);
        return (R) this;
    }

    @SuppressWarnings("unchecked")
    public R params(String key, List<String> value) {
        params.put(key, value);
        return (R) this;
    }




    public RetrofitHttpService getDefaultService() {

        return InstanceHolder.SERVICE;
    }


    private static class InstanceHolder {
        private static final RetrofitHttpService SERVICE =
                HttpConnector.InstanceHolder.retrofit.create(RetrofitHttpService.class);
    }


}
