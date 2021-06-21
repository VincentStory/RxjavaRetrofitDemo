package com.example.rxjava;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjava.utils.AppManager;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/6/17 3:04 PM
 * desc   :
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        findViewById(R.id.tv_go).setOnClickListener(l -> {
            startActivity(new Intent(this, MainActivity.class));

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().exitApp();
    }
}
