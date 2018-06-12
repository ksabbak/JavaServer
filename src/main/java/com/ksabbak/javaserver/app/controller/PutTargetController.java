package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.List;
import java.util.Map;

public class PutTargetController extends Controller {

    public PutTargetController(List<HTTPMethod> methods){
        super(methods);
    }

    public String bodyPost(String body){
        Map<String, String> params = super.stringToHashMap(body);
        String responseBody = "My=";
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (param.getKey() == "My") {
                responseBody += param.getKey() + "=" + param.getValue();
            }
        }
        return responseBody;
    }
}
