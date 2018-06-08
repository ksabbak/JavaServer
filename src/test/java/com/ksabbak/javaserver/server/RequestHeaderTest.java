package com.ksabbak.javaserver.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestHeaderTest {
    @Test
    public void requestHeaderTestSimpleHeader(){
        String headerString = "GET /path HTTP/1.1";
        RequestHeader requestHeader = new RequestHeader(headerString);

        assertEquals(HTTPMethod.GET, requestHeader.method);
        assertEquals("/path", requestHeader.path);
        assertEquals(headerString, requestHeader.text);
    }

    @Test
    public void requestHeaderTestSlightlyLongerSimpleHeader(){
        String headerString = "POST /pathy/path HTTP/1.1";
        RequestHeader requestHeader = new RequestHeader(headerString);

        assertEquals(HTTPMethod.POST, requestHeader.method);
        assertEquals("/pathy/path", requestHeader.path);
        assertEquals(headerString, requestHeader.text);
    }

}