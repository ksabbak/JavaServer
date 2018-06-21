package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;

public class RedirectController extends Controller {

    @Override
    public Response get(String params) {
        StatusCode status = StatusCode.FOUND;
        String redirectLocation = "/";
        return new Response.ResponseBuilder(status).location(redirectLocation).build();
    }
}
