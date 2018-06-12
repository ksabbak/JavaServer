package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String bodyGet(){
        return "";
    }

    public StatusCode statusHead(){
        return StatusCode.OK;
    }

    public StatusCode statusPost(){
        return StatusCode.OK;
    }

    public String bodyPost(String body){
        return "";
    }

    public StatusCode statusPut() { return StatusCode.OK; }

    public String bodyPut(String body){
        return "";
    }

    protected Map<String, String> stringToHashMap(String unparsedParams){
        Map<String, String> params = new HashMap<String, String>();
        String[] splitParams = unparsedParams.split("&");
        for(int i=0; i < splitParams.length; i++){
            String[] keyValuePair = splitParams[i].split("=");
            params.put(keyValuePair[0], keyValuePair[1]);
        }
        return params;
    }
}
