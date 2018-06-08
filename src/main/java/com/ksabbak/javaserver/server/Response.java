package com.ksabbak.javaserver.server;

import java.io.UnsupportedEncodingException;

public class Response {
    private final String NEW_LINE = "\n";
    private final String CRLF = "\r\n\r\n";

    private String header;
    private String body;

    public Response(String status, String body){
        this.header = startHeader(status);
        if (!body.isEmpty()){
            header += contentLength(body);
        }
        this.body = body;
    }

    private String startHeader(String status){

        return "HTTP/1.1 " + status;
    }

    private String contentLength(String body){
        byte[] bytes = new byte[0];
        try {
            bytes = body.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return NEW_LINE + "Content-Length: " + bytes.length;
    }

    public String formattedResponse(){
        return header + CRLF + body;
    }

    public String getHeader(){
        return header;
    }

    public String getBody(){
        return body;
    }

}
