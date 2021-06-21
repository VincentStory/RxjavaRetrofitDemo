package com.example.rxjava.http;

public class QCodeException extends RuntimeException {
    private int code;

    public QCodeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
