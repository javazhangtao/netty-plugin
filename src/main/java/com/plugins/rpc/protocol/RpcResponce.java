package com.plugins.rpc.protocol;

/**
 * rpc 响应对象
 * Created by zhangtao on 2015/11/30.
 */
public class RpcResponce {

    String requestId;//请求Id
    Integer code;//响应码
    Throwable error;//错误信息
    String message;//描述
    Object result;//返回对象

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
