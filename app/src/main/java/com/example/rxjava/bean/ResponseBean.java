package com.example.rxjava.bean;

import java.util.List;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/6/18 3:19 PM
 * desc   :
 */
public class ResponseBean {
    List<ResultBean> data;

    public List<ResultBean> getData() {
        return data;
    }

    public void setData(List<ResultBean> data) {
        this.data = data;
    }
}
