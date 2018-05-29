package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoutesTest {

    @Test
    public void validRequestTest() {
        StatusCode statusCode = Routes.validRequest("GET", "/");
        assertEquals(StatusCode.OK, statusCode);

        statusCode =  Routes.validRequest("OPTIONS", "/");
        assertEquals(StatusCode.NOT_FOUND, statusCode);

        statusCode =  Routes.validRequest("GET", "/foobar");
        assertEquals(StatusCode.NOT_FOUND, statusCode);
    }
}