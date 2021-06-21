# RxjavaRetrofitDemo
Rxjava+Retrofit+Okhttp更优封装方案

示例代码：
```
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
  ```
