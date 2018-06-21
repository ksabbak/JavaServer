package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Persistable;

import java.util.Map;

public class PutTargetController extends Controller {
    @Override
    public Response put(String params, Persistable storage){
        StatusCode status = StatusCode.OK;
        String body = bodyPost(params);
        return new Response.ResponseBuilder(status).body(body).build();
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
