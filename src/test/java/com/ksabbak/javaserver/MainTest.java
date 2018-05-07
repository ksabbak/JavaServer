package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testTesting() {
        assertTrue("This test should always return true", true);
    }

    @Test
    public void statusCodeTest() {
        Server server = new Server();
        String result = server.statusCode();
        assertEquals("Status: 200 OK", "200 OK", result);
    }
}