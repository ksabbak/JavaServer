package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void createResponseHeader1(){
        String expectedResponse = "HTTP/1.1 200 OK\r\n\r\n";
        String actualResponse = Response.createResponse("200 OK");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void createResponseHeader2(){
        String expectedResponse = "HTTP/1.1 422 Unprocessable Entity\r\n\r\n";
        String actualResponse = Response.createResponse("422 Unprocessable Entity");

        assertEquals(expectedResponse, actualResponse);
    }

}