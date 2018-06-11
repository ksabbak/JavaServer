package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.app.controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class RequestParser {
    private final int METHOD_POSITION = 0;
    private final int PATH_POSITION = 1;
    private final int CONTENT_LENGTH_POSITION = 1;
    private final String CONTENT_LENGTH = "Content-Length";

    private String text;
    private HTTPMethod method;
    private String path;
    private int contentLength = 0;
    private String body = "";

    public RequestParser(String unparsedHeader){
        text = unparsedHeader;
        method = toHTTPMethod(pullElement(METHOD_POSITION));
        path = pullElement(PATH_POSITION);
        if(text.contains(CONTENT_LENGTH)){
            contentLength = pullContentLength();
        }
    }

    public RequestData parse(){
        return new RequestData(method, path, body);
    }

    public void addBody(List<Integer> unparsedBody){
        body = parseBody(unparsedBody);
    }

    public String getText(){
        return text;
    }

    public int getContentLength(){
        return contentLength;
    }

    public String getBody() {
        return body;
    }

    public String getPath() {
        return path;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    private String parseBody(List<Integer> unparsedRequest){
        int size = unparsedRequest.size();
        String parsedRequest = "";
        for (Integer charOfUnparsedRequest : unparsedRequest) {
            int simpleInt = charOfUnparsedRequest;
            char nextChar = (char) simpleInt;
            String nextCharAsString = (String.valueOf(nextChar));
            parsedRequest += nextCharAsString;
        }
        return parsedRequest;
    }

    private String pullElement(int elementPosition){
        String[] components = text.split(" ");
        return components[elementPosition];
    }

    private int pullContentLength(){
        String[] components = text.split("\\R+");
        for (String component : components) {
            if (component.contains(CONTENT_LENGTH)) {
                String[] words = component.split(" ");
                return Integer.parseInt(words[CONTENT_LENGTH_POSITION]);
            }
        }
        return 0;
    }

    private HTTPMethod toHTTPMethod(String method){
        HTTPMethod formattedMethod;
        try {
            formattedMethod = HTTPMethod.valueOf(method);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            formattedMethod = HTTPMethod.UNKNOWN;
        }
        return formattedMethod;
    }
}
