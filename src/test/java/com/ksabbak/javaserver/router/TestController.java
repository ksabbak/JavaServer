package com.ksabbak.javaserver.router;

import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Persistable;

class TestController extends Controller {
    @Override
    public Response get(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).body("GET").build();
    }

    @Override
    public Response head(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).body("HEAD").build();
    }

    @Override
    public Response post(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).body("POST").build();
    }

    @Override
    public Response put(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).body("PUT").build();
    }

    @Override
    public Response delete(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).body("DELETE").build();
    }

    @Override
    public Response options(String params, Persistable storage) {
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).body("OPTIONS").build();
    }

}
