package com.example.rxjava.rxhttp;


import android.util.Log;

import com.example.rxjava.runner.MThreadRunner;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public final class MSchedulers {
    /**
     * RxJava 全局错误拦截，全局线程控制
     */
    public static void initRxJava() {
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.from(MThreadRunner.getInstance().getExecutor()));
        RxJavaPlugins.setErrorHandler(throwable -> Log.e("MSchedulers",throwable.getMessage()));

    }



    public static <T> FlowableTransformer<T, T> composeThread() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
