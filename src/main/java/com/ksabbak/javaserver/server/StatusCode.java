package com.ksabbak.javaserver.server;

public enum StatusCode {
    OK(200, "OK"),
    CREATED(201, "Created"),
    FOUND(302, "Found"),
    CONFLICT(409, "Conflict"),
    NOT_FOUND(404, "Not Found"),
    NOT_ALLOWED(405, "Method Not Allowed"),
    TEAPOT(418, "I'm a teapot");


    public int code;
    public String text;

    private StatusCode(int code, String text){
        this.code = code;
        this.text = text;
    }

    public String statusAsString(){
        return Integer.toString(this.code) + " " + this.text;
    }

}
