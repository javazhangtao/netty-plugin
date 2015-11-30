package com.plugins.rpc.protocol;

/**
 * rpc 请求对象
 * Created by zhangtao on 2015/11/30.
 */
public class RpcRequest {
    String requestId;//请求Id
    String className;//请求server名
    String methodName;//调用方法名
    Class<?> parameterTypes;//调用方法参数类型数组
    Object[] parameters;//调用方法参数数组

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?> getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?> parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
