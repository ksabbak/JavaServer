package com.ksabbak.javaserver.app.controller;

public class CoffeeController extends Controller {
    public CoffeeController(Object[] methods){
        super(methods);
    }

    public StatusCode statusGet(){
        return StatusCode.TEAPOT;
    }

    public String bodyGet(){
        return "I'm a teapot";
    }
}
