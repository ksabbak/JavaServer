package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void createResponseHeader(){
        String expectedResponse = "HTTP/1.1 200 OK\r\n\r\n";
        String actualResponse = Response.createResponse("200 OK");
        assertEquals(expectedResponse, actualResponse);

        expectedResponse = "HTTP/1.1 422 Unprocessable Entity\r\n\r\n";
        actualResponse = Response.createResponse("422 Unprocessable Entity");
        assertEquals(expectedResponse, actualResponse);
    }

}