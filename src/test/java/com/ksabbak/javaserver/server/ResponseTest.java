package com.ksabbak.javaserver.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void responseTestSimple(){
        String expectedResponse = "HTTP/1.1 200 OK\r\n\r\n";
        Response response = new Response.ResponseBuilder(StatusCode.OK).build();
        assertEquals(StatusCode.OK, response.getStatus());
//        assertEquals(expectedResponse, response.getResponse());
    }

    @Test
    public void responseTestWithBody(){
        String expectedResponse = "HTTP/1.1 200 OK\nContent-Length: 11\r\n\r\nHello World";
        Response response = new Response.ResponseBuilder(StatusCode.OK).body("Hello World").build();
        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("11", response.getHeaders().get("Content-Length"));
//        assertEquals(expectedResponse, response.getResponse());
//        assertTrue(response.getHeader().contains("Content-Length: 11"));
    }

    @Test
    public void responseTestWithAllow(){
        List<String> options = new ArrayList<String>() {{
            add("GET");
            add("HEAD");
            add("OPTIONS");
            add("DELETE");
        }};
        Response response = new Response.ResponseBuilder(StatusCode.OK).options(options).build();
        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("GET, HEAD, OPTIONS, DELETE", response.getHeaders().get("Allow"));
    }


}