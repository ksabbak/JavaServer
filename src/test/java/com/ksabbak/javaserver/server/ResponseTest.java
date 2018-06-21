package com.ksabbak.javaserver.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void responseTestSimple(){
        Response response = new Response.ResponseBuilder(StatusCode.OK).build();
        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void responseTestWithBody(){
        Response response = new Response.ResponseBuilder(StatusCode.OK).body("Hello World").build();
        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("11", response.getHeaders().get("Content-Length"));
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

    @Test
    public void formattedResponseWithRedirect(){
        String expectedResponse = "HTTP/1.1 302 Found\nLocation: /redirect\r\n\r\n";
        Response response = new Response.ResponseBuilder(StatusCode.FOUND).location("/redirect").build();
        assertEquals(StatusCode.FOUND, response.getStatus());
        assertEquals("/redirect", response.getHeaders().get("Location"));
    }

}