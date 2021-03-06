package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.KeyNotFoundException;
import com.ksabbak.javaserver.storage.Persistable;

import java.util.Map;

public class CatFormDataController extends Controller {

    @Override
    public Response get(String params, Persistable storage) {
        String key = "data";
        return storage.read(key)
                .map(val -> key + "=" + val)
                .map(body -> new Response.ResponseBuilder(StatusCode.OK).body(body))
                .map(builder -> builder.build())
                .orElse(super.get(params, storage));
    }

    @Override
    public Response put(String params, Persistable storage) {
        StatusCode statusCode = StatusCode.OK;

        Map<String, String> formattedParams = super.stringToHashMap(params);

        for(Map.Entry<String, String> pair : formattedParams.entrySet()) {
            if (pair.getKey().equals("data")) {
                try {
                    storage.update(pair.getKey(), pair.getValue());
                    return new Response.ResponseBuilder(statusCode).build();
                } catch (KeyNotFoundException e) {
                    System.out.println("Key doesn't exist; cannot update error");
                    e.printStackTrace();
                    statusCode = StatusCode.CONFLICT;
                }
            }
        }
        return new Response.ResponseBuilder(statusCode).build();
    }

    @Override
    public Response delete(String params, Persistable storage) {
        try {
            storage.delete("data");
            StatusCode statusCode = StatusCode.OK;
            return new Response.ResponseBuilder(statusCode).build();
        } catch (KeyNotFoundException e) {
            System.out.println("Key doesn't exist; cannot delete error");
            e.printStackTrace();
        }

        return super.delete(params, storage);
    }
}
