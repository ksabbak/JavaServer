package com.ksabbak.javaserver;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeaderTest {

    @Test
    public void methodAttributeTest(){
        Header header = new Header("GET /path HTTP/1.1");
        assertEquals("GET", header.method);

        header = new Header("POST /path HTTP/1.1");
        assertEquals("POST", header.method);
    }

    @Test
    public void pathAttributeTest(){
        Header header = new Header("GET /path HTTP/1.1");
        assertEquals("/path", header.path);

        header = new Header("POST /pathy/path HTTP/1.1");
        assertEquals("/pathy/path", header.path);
    }

    @Test
    public void textAttributeTest(){
        String unparsedHeader = "GET /path HTTP/1.1";
        Header header = new Header(unparsedHeader);
        assertEquals(unparsedHeader, header.text);

        unparsedHeader = "POST /pathy/path HTTP/1.1";
        header = new Header(unparsedHeader);
        assertEquals(unparsedHeader, header.text);
    }

}