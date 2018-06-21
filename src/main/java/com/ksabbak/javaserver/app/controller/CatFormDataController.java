package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Persistable;

import java.util.Map;

public class CatFormDataController extends Controller {

    @Override
    public Response get(String params, Persistable storage) {
        String key = "data";
        try{
            String value = storage.read(key);
            String body = key + "=" + value;
            StatusCode status = StatusCode.OK;
            return new Response.ResponseBuilder(status).body(body).build();
        }catch (Exception e) {
            System.out.println("Can't find key: " + key);
            return super.get(params, storage);
        }
    }

    @Override
    public Response put(String params, Persistable storage) {
        StatusCode statusCode = StatusCode.OK;

        Map<String, String> formattedParams = super.stringToHashMap(params);

        for(Map.Entry<String, String> pair : formattedParams.entrySet()) {
            System.out.println(pair.getKey());
            if (pair.getKey().equals("data")) {
                try {
                    storage.update(pair.getKey(), pair.getValue());
                    return new Response.ResponseBuilder(statusCode).build();
                } catch (Exception e) {
                    System.out.println("Key doesn't exist; cannot update error");
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
        } catch (Exception e) {
            System.out.println("Key doesn't exist; cannot delete error");
        }

        return super.delete(params, storage);
    }
}
