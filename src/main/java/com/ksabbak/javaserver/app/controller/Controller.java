package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Persistable;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Controller {

    public Response get(String params, Persistable storage){
        StatusCode status = StatusCode.NOT_FOUND;
        return new Response.ResponseBuilder(status).build();
    }

    public Response head(String params, Persistable storage){
        StatusCode status = StatusCode.NOT_FOUND;
        return new Response.ResponseBuilder(status).build();
    }

    public Response options(String params, Persistable storage){
        StatusCode status = StatusCode.OK;
        List<String> options = getOptions(this);
        return new Response.ResponseBuilder(status).options(options).build();
    }

    public Response post(String params, Persistable storage){
        StatusCode status = StatusCode.NOT_ALLOWED;
        return new Response.ResponseBuilder(status).build();
    }

    public Response put(String params, Persistable storage){
        StatusCode status = StatusCode.NOT_ALLOWED;
        return new Response.ResponseBuilder(status).build();
    }

    public Response delete(String params, Persistable storage){
        StatusCode status = StatusCode.NOT_ALLOWED;
        return new Response.ResponseBuilder(status).build();
    }

    public Response unknown(String params, Persistable storage){
        StatusCode status = StatusCode.NOT_ALLOWED;
        return new Response.ResponseBuilder(status).build();
    }

    protected Map<String, String> stringToHashMap(String unparsedParams){
        Map<String, String> params = new HashMap<String, String>();
        String[] splitParams = unparsedParams.split("&");
        for(String splitParam : splitParams){
            String[] keyValuePair = splitParam.split("=");

            params.put(keyValuePair[0], keyValuePair[1]);
        }
        return params;
    }

    protected List<String> getOptions(Controller subclass){
        List<String> methods = new ArrayList<String>();
        methods.add("OPTIONS");
        Method[] subMethods = subclass.getClass().getDeclaredMethods();
        for ( Method subMethod: subMethods) {
            String name = subMethod.getName().toUpperCase();
            if(HTTPMethod.verifyMethod(name) != HTTPMethod.UNKNOWN){
                methods.add(name);
            }
        }
        return methods;
    }
}
