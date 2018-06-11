package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.List;
import java.util.Map;

public class FormController extends Controller {
    public FormController(List<HTTPMethod> methods){
        super(methods);
        System.out.println(this.methods);
    }

    public String bodyPost(String body){
        Map<String, String> params = super.stringToHashMap(body);
        String responseBody = "";
        for (Map.Entry<String, String> param : params.entrySet()) {
            responseBody += param.getKey() + "=" + param.getValue();
        }
        return responseBody;
    }
}
