package com.ksabbak.javaserver.server;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RequestHeaderTest {
    @Test
    public void requestHeaderTestSimpleHeader(){
        String headerString = "GET /path HTTP/1.1";
        List<Integer> headerList = toIntArray(headerString);
        RequestHeader requestHeader = new RequestHeader(headerList);

        assertEquals(HTTPMethod.GET, requestHeader.method);
        assertEquals("/path", requestHeader.path);
        assertEquals(headerString, requestHeader.text);
    }

    @Test
    public void requestHeaderTestSlightlyLongerSimpleHeader(){
        String headerString = "POST /pathy/path HTTP/1.1";
        List<Integer> headerList = toIntArray(headerString);
        RequestHeader requestHeader = new RequestHeader(headerList);

        assertEquals(HTTPMethod.POST, requestHeader.method);
        assertEquals("/pathy/path", requestHeader.path);
        assertEquals(headerString, requestHeader.text);
    }

    public List<Integer> toIntArray(String string){
        List<Integer> intArray = new ArrayList<Integer>();
        for(int i=0; i < string.length(); i++){
            intArray.add((int)(string.charAt(i)));
        }
        return intArray;
    }
}