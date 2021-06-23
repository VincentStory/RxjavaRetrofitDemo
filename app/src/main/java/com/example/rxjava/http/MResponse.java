package com.example.rxjava.http;

import com.google.gson.annotations.SerializedName;

public class MResponse<T> {
    private int code;
    private String message;
    @SerializedName("currentTime")
    private long time;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
