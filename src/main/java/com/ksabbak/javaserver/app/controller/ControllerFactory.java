package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.app.Routes;
import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.List;

public class ControllerFactory {
    public static Controller getController(String path){
        List<HTTPMethod> methods = Routes.methodsForPath(path);
        switch(path) {
            case "/coffee":
                return new CoffeeController(methods);
            default:
                return new Controller(methods);
        }
    }
}
