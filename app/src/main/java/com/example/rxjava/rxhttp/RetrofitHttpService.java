package com.example.rxjava.rxhttp;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/4/27 3:01 PM
 * desc   : 通用的HTTP请求处理
 */
public interface RetrofitHttpService {

    @GET()
    Flowable<String> get(@Url String url, @QueryMap Map<String, Object> params, @HeaderMap Map<String, String> header);


    @GET()
    Flowable<Response<String>> get(@Url String url, @QueryMap Map<String, Object> params);


    @GET()
    Call<Response<String>> getCall(@Url String url, @QueryMap Map<String, Object> params);

    Flowable<Response<String>> post(@Url String url, @QueryMap Map<String, Object> params);

    @POST()
    Flowable<Response<String>> postHeaders(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, Object> params);

    @POST()
    Flowable<Response<String>> postBody(@Url String url, @HeaderMap Map<String, String> headers, @Body Map<String, Object> params);

}
