package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.app.Routes;

public class ControllerFactory {
    public static Controller getController(String path){
        Object[] methods = Routes.methodsForPath(path);
        switch(path) {
            case "/coffee":
                return new CoffeeController(methods);
            case "/form":
                return new FormController(methods);
            case "/redirect":
                return new RedirectController(methods);
            default:
                return new Controller(methods);
        }
    }
}
