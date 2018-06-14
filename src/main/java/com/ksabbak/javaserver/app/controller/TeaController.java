package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;

public class TeaController extends Controller {
    @Override
    public Response get(String params){
        StatusCode status = StatusCode.OK;
        return new Response.ResponseBuilder(status).build();
    }
}
