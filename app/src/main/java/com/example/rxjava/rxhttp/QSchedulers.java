package com.example.rxjava.rxhttp;


import android.util.Log;

import com.example.rxjava.runner.QTThreadRunner;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public final class QSchedulers {
    /**
     * RxJava 全局错误拦截，全局线程控制
     */
    public static void initRxJava() {
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.from(QTThreadRunner.getInstance().getExecutor()));
        RxJavaPlugins.setErrorHandler(throwable -> Log.e("QSchedulers",throwable.getMessage()));

    }



    public static <T> FlowableTransformer<T, T> composeThread() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    public static <T> FlowableTransformer<T, T> composeLifecycle(LifecycleTransformer<T> transformer) {
//        return upstream -> {
//            if (transformer == null) {
//                return upstream;
//            } else {
//                return upstream.compose(transformer);
//            }
//        };
//    }
}
