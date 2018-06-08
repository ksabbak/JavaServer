package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.List;

public class CoffeeController extends Controller {
    public CoffeeController(List<HTTPMethod> methods){
        super(methods);
    }

    public StatusCode statusGet(){
        return StatusCode.TEAPOT;
    }

    public String bodyGet(){
        return "I'm a teapot";
    }
}
