package com.example.srp.utils;

public class Result<T> {
    private T data;
    private Meta meta = new Meta();

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return success(data, "成功！");
    }

    public static <T> Result<T> success(T data, String msg) {
        Result<T> result = new Result<>(data);
        result.meta.setStatus(200);
        result.meta.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.meta.setStatus(code);
        result.meta.setMsg(msg);
        return result;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
