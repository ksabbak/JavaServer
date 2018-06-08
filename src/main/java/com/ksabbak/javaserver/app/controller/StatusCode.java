package com.ksabbak.javaserver.app.controller;

public enum StatusCode {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
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
