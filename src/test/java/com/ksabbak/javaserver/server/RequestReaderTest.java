package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.server.request.Request;
import com.ksabbak.javaserver.server.request.RequestReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RequestReaderTest {

    @Test
    public void readRequestNoBody(){
        String requestString = "GET /path HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(requestString));
        String request = RequestReader.readHeader(in);

        assertEquals(requestString, request);
    }

    @Test
    public void readRequestWithBody(){
        String requestString = "POST /pathy/path HTTP/1.1\nContent-Length: 11\r\n\r\nHello World";
        BufferedReader in = new BufferedReader(new StringReader(requestString));
        String header = RequestReader.readHeader(in);
        List<Integer> body = RequestReader.readBody(in, 11);

        assertEquals("POST /pathy/path HTTP/1.1\nContent-Length: 11", header);
        assertEquals(toIntArray("Hello World"), body);
    }


    private List<Integer> toIntArray(String string){
        List<Integer> intArray = new ArrayList<Integer>();
        for(int i=0; i < string.length(); i++){
            intArray.add((int)(string.charAt(i)));
        }
        return intArray;
    }
}