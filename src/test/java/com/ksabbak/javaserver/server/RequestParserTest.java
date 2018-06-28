package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.server.request.Request;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class RequestParserTest {
    @Test
    public void requestParserTestSimpleHeader(){
        String header = "GET /path HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        assertEquals(HTTPMethod.GET, request.getMethod());
        assertEquals("/path", request.getPath());
    }

    @Test
    public void requestParserTestSlightlyLongerSimpleHeader(){
        String header = "POST /pathy/path HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        assertEquals(HTTPMethod.POST, request.getMethod());
        assertEquals("/pathy/path", request.getPath());
    }

    @Test
    public void requestParserTestAddBodyWithBody(){
        String header = "GET /path HTTP/1.1\nContent-Length: 11\r\n\r\nHello World";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        assertEquals("Hello World", request.getBody());
    }

    @Test
    public void requestParserTestAddBodyNoBody(){
        String header = "GET /path HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        assertEquals("", request.getBody());
    }


}
