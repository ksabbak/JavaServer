package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Persistable;

import java.util.List;

public class MethodOptions2Controller extends Controller {

    @Override
    public Response get(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).build();
    }

    @Override
    public Response head(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).build();
    }

}