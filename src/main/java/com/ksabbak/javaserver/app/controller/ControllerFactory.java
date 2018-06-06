package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.app.Routes;

public class ControllerFactory {
    public static Controller getController(String path){
        Object[] methods = Routes.methodsForPath(path);
        switch(path) {
            case "/coffee":
                return new CoffeeController(methods);
            default:
                return new Controller(methods);
        }
    }
}
