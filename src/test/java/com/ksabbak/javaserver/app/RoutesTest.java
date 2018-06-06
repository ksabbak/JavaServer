package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.server.HTTPMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoutesTest {

    @Test
    public void methodsForPathExistingPath() {
        Object[] methods = Routes.methodsForPath("/");
        Object[] expected = new Object[] {HTTPMethod.GET, HTTPMethod.HEAD};
        assertArrayEquals(expected, methods);
    }
}