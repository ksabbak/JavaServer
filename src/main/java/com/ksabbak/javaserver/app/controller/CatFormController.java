package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;

public class CatFormController extends Controller {

    @Override
    public Response post(String params) {
        StatusCode statusCode = StatusCode.CREATED;
        return new Response.ResponseBuilder(statusCode).location("/cat-form/data").build();
    }
}
