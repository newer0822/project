package com.erp.domain;

import java.io.Serializable;

/**
 * 实体类
 */
public class RequestMessage implements Serializable {

    private static final long serialVersionUID = -6018919043384470119L;
    private String id;
    private String url;         //请求的url
    private String methodName; //请求的方法
    private String args;       //请求的参数
    private String method;     //请求方式：get / post / put/delete /...


    public RequestMessage() {
    }

    public RequestMessage(String id, String url, String methodName, String args, String method) {
        this.id = id;
        this.url = url;
        this.methodName = methodName;
        this.args = args;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
