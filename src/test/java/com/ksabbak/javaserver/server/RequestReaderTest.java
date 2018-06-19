package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.server.request.Request;
import com.ksabbak.javaserver.server.request.RequestReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class RequestReaderTest {

    @Test
    public void readRequestNoBody(){
        String requestString = "GET /path HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(requestString));
        RequestReader requestReader = new RequestReader(in);
        Request request = requestReader.read();
        assertEquals("/path", request.getPath());
        assertEquals("", request.getBody());
    }

    @Test
    public void readRequestWithBody(){
        String requestString = "POST /pathy/path HTTP/1.1\nContent-Length: 11\r\n\r\nHello World";
        BufferedReader in = new BufferedReader(new StringReader(requestString));
        RequestReader requestReader = new RequestReader(in);
        Request request = requestReader.read();
        assertEquals("/pathy/path", request.getPath());
        assertEquals("Hello World", request.getBody());
    }
}