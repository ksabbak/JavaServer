package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoutesTest {

    @Test
    public void validRequestTestValidPathValidMethod() {
        StatusCode statusCode = Routes.validRequest("GET", "/");
        assertEquals(StatusCode.OK, statusCode);
    }

    @Test
    public void validRequestTestValidPathInvalidMethod() {
        StatusCode statusCode = Routes.validRequest("OPTIONS", "/");
        assertEquals(StatusCode.NOT_FOUND, statusCode);
    }

    @Test
    public void validRequestTestInvalidPath() {
        StatusCode statusCode = Routes.validRequest("GET", "/invalid-path");
        assertEquals(StatusCode.NOT_FOUND, statusCode);
    }
}

