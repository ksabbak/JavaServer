package com.ksabbak.javaserver.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RequestParserTest {
    @Test
    public void requestParserTestSimpleHeader(){
        String header = "GET /path HTTP/1.1";
        RequestParser requestParser = new RequestParser(header);

        assertEquals(HTTPMethod.GET, requestParser.getMethod());
        assertEquals("/path", requestParser.getPath());
        assertEquals(header, requestParser.getText());
    }

    @Test
    public void requestParserTestSlightlyLongerSimpleHeader(){
        String header = "POST /pathy/path HTTP/1.1";
        RequestParser requestParser = new RequestParser(header);

        assertEquals(HTTPMethod.POST, requestParser.getMethod());
        assertEquals("/pathy/path", requestParser.getPath());
        assertEquals(header, requestParser.getText());
    }

    @Test
    public void requestParserTestWithContentLength(){
        String header = "POST /pathy/path HTTP/1.1\nContent-Length: 11";
        RequestParser requestParser = new RequestParser(header);

        assertEquals(11, requestParser.getContentLength());
    }

    @Test
    public void requestParserTestAddBodyWithBody(){
        String header = "GET /path HTTP/1.1";
        RequestParser requestParser = new RequestParser(header);
        String request = "Hello World";
        List<Integer> bodyList = toIntArray(request);
        requestParser.addBody(bodyList);

        assertEquals(request, requestParser.getBody());
    }

    @Test
    public void requestParserTestAddBodyNoBody(){
        String header = "GET /path HTTP/1.1";
        RequestParser requestParser = new RequestParser(header);
        requestParser.addBody(new ArrayList<Integer>());

        assertEquals("", requestParser.getBody());
    }

    public List<Integer> toIntArray(String string){
        List<Integer> intArray = new ArrayList<Integer>();
        for(int i=0; i < string.length(); i++){
            intArray.add((int)(string.charAt(i)));
        }
        return intArray;
    }

}
