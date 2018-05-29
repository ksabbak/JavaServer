package com.ksabbak.javaserver;

public class Response {

    public static String createResponse(String status){
        return "HTTP/1.1 " + status + "\r\n\r\n";
    }

}
