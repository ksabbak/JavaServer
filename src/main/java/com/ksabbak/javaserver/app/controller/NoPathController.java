package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;

public class NoPathController extends Controller {

    @Override
    public Response post(String params){
        StatusCode status = StatusCode.NOT_FOUND;
        return new Response.ResponseBuilder(status).build();
    }

    @Override
    public Response put(String params){
        StatusCode status = StatusCode.NOT_FOUND;
        return new Response.ResponseBuilder(status).build();
    }

}
