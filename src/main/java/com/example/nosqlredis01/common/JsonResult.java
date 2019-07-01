package com.example.nosqlredis01.common;

/**
 * Created by raoxiaokang on 2019/6/14.
 * json格式数据封装
 */
public class JsonResult {
    private int code;
    private String message;
    private Object data;

    public JsonResult(int code) {
        this.code = code;
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
