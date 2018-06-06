package com.ksabbak.javaserver.app.controller;

public class Controller {
    protected Object[] methods;

    public Controller(){
        this(new Object[]{});
    }

    public Controller(Object[] methods){
        this.methods = methods;
    }

    public final Object[] getMethods(){
        return methods;
    }

    public StatusCode statusGet(){
        return StatusCode.OK;
    }

    public StatusCode statusHead(){
        return StatusCode.OK;
    }

    public String bodyGet(){
        return "";
    }

}
