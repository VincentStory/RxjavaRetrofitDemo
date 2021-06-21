package com.example.rxjava.rxhttp;


import android.util.Log;
import android.widget.Toast;

import com.example.rxjava.utils.ContextUtil;
import com.example.rxjava.http.QCodeException;

import java.net.UnknownHostException;

import io.reactivex.subscribers.DisposableSubscriber;

public abstract class QSubscriber<T> extends DisposableSubscriber<T> {
    private String TAG = getClass().getSimpleName();



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "onNext");
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "onComplete");
    }

    @Override
    public void onError(Throwable t) {
//        if (t instanceof QCodeException) {
//            onCodeException((QCodeException) t);
//        } else {
//            onThrowable(t);
//        }
        onThrowable(t);
    }


    protected void onThrowable(QCodeException t) {
        Log.i(TAG, t.getCode() + t.getMessage());
        Toast.makeText(ContextUtil.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
    }
    protected void onThrowable(Throwable t) {
        if (t instanceof UnknownHostException) { // 网络异常
            Log.i(TAG, t.getMessage());
        }  else {
            Log.i(TAG, t.getMessage());
        }

        Toast.makeText(ContextUtil.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
    }
}
