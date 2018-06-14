package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;

import java.util.Map;

public class FormController extends Controller {

    @Override
    public Response post(String params){
        StatusCode status = StatusCode.OK;
        String body = bodyPost(params);

        return new Response.ResponseBuilder(status).body(body).build();
    }

    private String bodyPost(String body){
        Map<String, String> params = super.stringToHashMap(body);
        String responseBody = "";
        for (Map.Entry<String, String> param : params.entrySet()) {
            responseBody += param.getKey() + "=" + param.getValue() + "\n";
        }
        return responseBody;
    }

}
