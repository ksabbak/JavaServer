package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeaderTest {
    @Test
    public void headerTestSimpleHeader(){
        String headerString = "GET /path HTTP/1.1";
        Header header = new Header(headerString);

        assertEquals("GET", header.method);
        assertEquals("/path", header.path);
        assertEquals(headerString, header.text);
    }

    @Test
    public void headerTestSlightlyLongerSimpleHeader(){
        String headerString = "POST /pathy/path HTTP/1.1";
        Header header = new Header(headerString);

        assertEquals("POST", header.method);
        assertEquals("/pathy/path", header.path);
        assertEquals(headerString, header.text);
    }

}