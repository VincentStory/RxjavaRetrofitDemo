package com.example.rxjava;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.rxjava.rxhttp.QSchedulers;
import com.example.rxjava.utils.ContextUtil;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/6/17 2:46 PM
 * desc   :
 */
public class QApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.i("app==","attachBaseContext");
        QSchedulers.initRxJava();
        ContextUtil.init(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("app==","onCreate");
        ContextUtil.init(this);
    }
}
