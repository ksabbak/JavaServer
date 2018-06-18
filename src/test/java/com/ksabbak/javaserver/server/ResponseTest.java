package com.ksabbak.javaserver.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void formattedResponseTestEmptyBody(){
        String expectedResponse = "HTTP/1.1 200 OK\r\n\r\n";
        Response response = new Response.ResponseBuilder(StatusCode.OK).build();
        assertEquals(expectedResponse, response.getResponse());
    }

    @Test
    public void formattedResponseTestWithBody(){
        String expectedResponse = "HTTP/1.1 200 OK\nContent-Length: 11\r\n\r\nHello World";
        Response response = new Response.ResponseBuilder(StatusCode.OK).body("Hello World").build();
        assertEquals(expectedResponse, response.getResponse());
        assertTrue(response.getHeader().contains("Content-Length: 11"));
    }


}