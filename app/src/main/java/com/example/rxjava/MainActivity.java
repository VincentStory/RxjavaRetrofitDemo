package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.rxjava.bean.ResponseBean;
import com.example.rxjava.rxhttp.QDialogSubscriber;
import com.example.rxjava.rxhttp.QSchedulers;
import com.example.rxjava.rxhttp.RequestClicent;
import com.example.rxjava.utils.AppManager;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import static com.example.rxjava.rxhttp.MRequest.getParams;

public class MainActivity extends AppCompatActivity {
    TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_content = findViewById(R.id.tv_content);

        AppManager.getInstance().addActivity(this);

        findViewById(R.id.tv_action).setOnClickListener(l -> {
            getData();
        });
    }


    private void getData() {
        String url = "http://app.bilibili.com" +
                "/x/feed/index?" ;

        RequestClicent.getInstance().getMRequest()
                .params("appkey","c1b107428d337928")
                .params("build","51900")
                .params("idx","0")
                .params("login_event","1")
                .params("mobi_app","android")
                .params("network","wifi")
                .params("open_event","cold")
                .params("platform","android")
                .params("pull",true)
                .params("style","2")
                .params("ts","1623998700")
                .params("sign","dbeff7cd5f21a97ffef2648aff33a8a1")
                .getDefaultService().get(url, getParams())
                .compose(QSchedulers.composeThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new QDialogSubscriber<ResponseBean>(true, true) {
                    @Override
                    protected void onSuccess(ResponseBean response) {
                        Log.i("data==", response.getData().toString());
                        tv_content.setText("网络数据返回:   " + response.getData().toString());
                    }
                });


//        Call<Response<String>> call = RequestClicent.getInstance().getMRequest()
//                .getDefaultService().getCall(ss, getParams());
//
//        call.enqueue(new Callback<Response<String>>() {
//            @Override
//            public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {
//                Log.i("data==", response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<Response<String>> call, Throwable t) {
//                Log.i("data==", t.toString());
//            }
//        });

    }


}