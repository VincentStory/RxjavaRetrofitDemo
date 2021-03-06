package com.example.rxjava.rxhttp;


import android.util.Log;

import com.example.rxjava.http.MCodeException;
import com.example.rxjava.utils.JSONUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Response;


public abstract class MResponseSubscriber<R> extends MSubscriber<Response<String>> {

    protected abstract void onSuccess(R response);

    protected Class<R> clazz;

    //传入的类型是否是response完整数据类型，默认只需要传dataBean类型就可以
    protected boolean isResponseBean = false;


    public MResponseSubscriber() {
        try {
            Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            clazz = (Class<R>) types[0];
        } catch (Throwable throwable) {
            onThrowable(throwable);
        }
    }


    @Override
    public void onNext(Response<String> response) {
        Log.i("json==", response.toString());
        if (response.body() instanceof String) {
            try {
                if (isResponseBean) {
                    //完整解析
                    R res = JSONUtils.toObj(response.body(), clazz);
                    onSuccess(res);
                } else {
                    //单独解析data数据¬
                    JSONObject jsonObject = new JSONObject(response.body());
//                    根据项目的具体数据格式，这里可能需要做一定程度的修改，就是将实际接口返回的数据名称，替换下面的code，message，data。
                    int code = jsonObject.optInt("code");
                    String msg = jsonObject.optString("message");
//                String currentTime = jsonObject.optString("currentTime");
                    String data = jsonObject.optString("data");

                    R res = JSONUtils.toObj(data, clazz);
                    if (code == 0) {
                        onSuccess(res);
                    } else {
                        onThrowable(new MCodeException(code, msg));
                    }
                }
            } catch (JSONException e) {
                onThrowable(e);
            }


        }
    }
}
