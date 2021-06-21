package com.example.rxjava.utils;

import android.app.Application;
import android.content.Context;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/6/21 10:33 AM
 * desc   :
 */
public class ContextUtil {
    private static Context context;

    private static Application application;

    public static void init(Application appContext) {
        application = appContext;
        context = appContext.getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static Application getAplication() {
        return application;
    }



}
