package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Persistable;

public class IndexController extends Controller {

    public Response get(String params, Persistable storage){
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).build();
    }

    public Response head(String params, Persistable storage){
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).build();
    }
}
