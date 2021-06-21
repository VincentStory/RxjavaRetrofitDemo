package com.example.rxjava.rxhttp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Window;


import com.example.rxjava.utils.AppManager;

import retrofit2.Response;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/4/25 5:56 PM
 * desc   :
 */
public abstract class QDialogSubscriber<R> extends QResponseSubscriber<R> {


    private ProgressDialog dialog;
    private Boolean isShowLoading = true;//是否展示加载框 默认展示



    public QDialogSubscriber() {
        initDialog(AppManager.getInstance().currentActivity());
    }

    public QDialogSubscriber(Boolean isShowLoading) {
        this.isShowLoading = isShowLoading;
        initDialog(AppManager.getInstance().currentActivity());
    }

    public QDialogSubscriber(Boolean isShowLoading, Boolean isResponseBean) {
        this.isShowLoading = isShowLoading;
        this.isResponseBean = isResponseBean;
        initDialog(AppManager.getInstance().currentActivity());
    }



    private void initDialog(Activity activity) {
        if (dialog == null) {
            dialog = new ProgressDialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("请求网络中...");
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DialogSubscriber==", "onStart");
        if (dialog != null && !dialog.isShowing() && isShowLoading) {
            dialog.show();
        }
    }


    @Override
    public void onNext(Response<String> response) {
        Log.i("DialogSubscriber==", "onNext");
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        super.onNext(response);
    }


    @Override
    protected void onThrowable(Throwable t) {
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        super.onThrowable(t);
        Log.i("DialogSubscriber==", "onThrowable" + t.getMessage());

    }
}
