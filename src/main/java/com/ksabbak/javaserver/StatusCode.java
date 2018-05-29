package com.ksabbak.javaserver;

public enum StatusCode {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found");


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
