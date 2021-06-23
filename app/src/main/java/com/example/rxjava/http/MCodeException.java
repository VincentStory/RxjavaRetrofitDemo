package com.example.rxjava.http;

public class MCodeException extends RuntimeException {
    private int code;

    public MCodeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
