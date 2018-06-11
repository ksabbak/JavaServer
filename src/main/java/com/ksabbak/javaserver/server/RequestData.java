package com.ksabbak.javaserver.server;

public class RequestData {
    private HTTPMethod method;
    private String path;
    private String body;

    public RequestData(HTTPMethod method, String path, String body){
        this.method = method;
        this.path = path;
        this.body = body;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    public String getPath(){
        return path;
    }

    public String getBody() {
        return body;
    }
}
