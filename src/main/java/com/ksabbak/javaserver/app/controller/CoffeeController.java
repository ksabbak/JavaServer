package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;

public class CoffeeController extends Controller {
    @Override
    public Response get(String params) {
        StatusCode status = StatusCode.TEAPOT;
        String body = "I'm a teapot";
        return new Response.ResponseBuilder(status).body(body).build();
    }
}
