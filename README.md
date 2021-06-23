# RxjavaRetrofitDemo


## 本工程主要实现以下功能：

1.实现网络加载效果统一处理，也可特殊处理，更加灵活

2.接口返回错误统一处理，也可以特殊处理

3.使用AutoDispose实现任务生命周期管理，为啥要弃用RxLiferecycle，可参考文章：https://blog.danlew.net/2017/08/02/why-not-rxlifecycle/

4.支持完整Respone解析，也支持Data单独解析，不用写过多重复代码

5.支持请求头统一处理，支持对请求数据统一加密

6.支持多个服务器接口地址请求，应对于正式环境有多个服务器地址的情况

7.无需再写接口IService，只需填写请求url地址配合DefaultService即可
       

## 示例代码：
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
