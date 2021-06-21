package com.example.rxjava.rxhttp;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/4/26 7:40 PM
 * desc   :
 */
public class RequestClicent {


    public static RequestClicent getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private static final RequestClicent instance = new RequestClicent();
    }

    public  MRequest getMRequest() {
        return new MRequest();
    }

}
