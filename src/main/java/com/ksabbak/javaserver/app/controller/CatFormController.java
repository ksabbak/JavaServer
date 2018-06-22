package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.KeyTakenException;
import com.ksabbak.javaserver.storage.Persistable;

import java.util.Map;

public class CatFormController extends Controller {

    @Override
    public Response post(String params, Persistable storage) {
        StatusCode statusCode = StatusCode.OK;

        Map<String, String> formattedParams = super.stringToHashMap(params);

        for(Map.Entry<String, String> pair : formattedParams.entrySet()) {
            if (pair.getKey().equals("data")) {
                try {
                    storage.create(pair.getKey(), pair.getValue());
                    statusCode = StatusCode.CREATED;
                    return new Response.ResponseBuilder(statusCode).location("/cat-form/data").build();
                } catch (KeyTakenException e) {
                    System.out.println("Key already exists error");
                    e.printStackTrace();
                    statusCode = StatusCode.CONFLICT;
                }
            }
        }
        return new Response.ResponseBuilder(statusCode).build();
    }


}
