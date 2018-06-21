package com.ksabbak.javaserver.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResponseFormatterTest {

    @Test
    public void formattedSimplestRequestTest() {
        String expectedResponse = "HTTP/1.1 200 OK\r\n\r\n";
        Response response = new Response.ResponseBuilder(StatusCode.OK).build();
        String formattedResponse = ResponseFormatter.format(response);

        assertEquals(expectedResponse, formattedResponse);
    }

    @Test
    public void formattedRequestWithBodyTest() {
        String expectedResponse = "HTTP/1.1 200 OK\nContent-Length: 11\r\n\r\nHello World";
        Response response = new Response.ResponseBuilder(StatusCode.OK).body("Hello World").build();
        String formattedResponse = ResponseFormatter.format(response);

        assertEquals(expectedResponse, formattedResponse);
    }

    @Test
    public void formattedRequestWithAllowAndBodyTest() {
        String expectedResponse = "HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS, DELETE\nContent-Length: 11\r\n\r\nHello World";

        List<String> options = new ArrayList<String>() {{
            add("GET");
            add("HEAD");
            add("OPTIONS");
            add("DELETE");
        }};

        Response response = new Response.ResponseBuilder(StatusCode.OK).options(options).body("Hello World").build();
        String formattedResponse = ResponseFormatter.format(response);

        assertEquals(expectedResponse, formattedResponse);
    }

    @Test
    public void formattedRequestWithLocationTest(){
        String expectedResponse = "HTTP/1.1 302 Found\nLocation: /redirect\r\n\r\n";
        Response response = new Response.ResponseBuilder(StatusCode.FOUND).location("/redirect").build();
        String formattedResponse = ResponseFormatter.format(response);

        assertEquals(expectedResponse, formattedResponse);
    }
}