package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.app.controller.StatusCode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void formattedResponseTestEmptyBody(){
        String expectedResponse = "HTTP/1.1 200 OK\r\n\r\n";
        Response response = new Response(StatusCode.OK.statusAsString(), "");
        assertEquals(expectedResponse, response.formattedResponse());
    }

    @Test
    public void formattedResponseTestWithBody(){
        String expectedResponse = "HTTP/1.1 200 OK\nContent-Length: 11\r\n\r\nHello World";
        Response response = new Response(StatusCode.OK.statusAsString(), "Hello World");
        assertEquals(expectedResponse, response.formattedResponse());
    }


}