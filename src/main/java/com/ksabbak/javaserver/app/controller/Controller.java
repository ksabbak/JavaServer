package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    protected List<HTTPMethod> methods;

    public Controller(){
        this(new ArrayList<HTTPMethod>());
    }

    public Controller(List<HTTPMethod> methods){
        this.methods = methods;
    }

    public final List<HTTPMethod> getMethods(){
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
