package com.ksabbak.javaserver.server;

import java.util.ArrayList;
import java.util.List;

public class RequestHeader {
    private final int METHOD_POSITION = 0;
    private final int PATH_POSITION = 1;

    public String text;
    public HTTPMethod method;
    public String path;

    public RequestHeader(List<Integer> unparsedHeader){
        text = parse(unparsedHeader);
        method = toHTTPMethod(pullElement(METHOD_POSITION));
        path = pullElement(PATH_POSITION);
    }

    private String pullElement(int elementPosition){
        String[] components = text.split(" ");
        return components[elementPosition];
    }

    private HTTPMethod toHTTPMethod(String method){
        HTTPMethod formattedMethod;
        try {
            formattedMethod = HTTPMethod.valueOf(method);
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            formattedMethod = HTTPMethod.UNKNOWN;
        }
        return formattedMethod;
    }

    private String parse(List<Integer> unparsedRequest){
        int size = unparsedRequest.size();
        String parsedRequest = "";
        for(int i=0; i < size; i++){
            int simpleInt = (int)unparsedRequest.get(i);
            char nextChar = (char)simpleInt;
            String nextCharAsString = (String.valueOf(nextChar));
            parsedRequest += nextCharAsString;
        }
        System.out.println(parsedRequest);
        return parsedRequest;
    }
}
//class ForLoopExample {
//    public static void main(String args[]){
//         for(int i=10; i>1; i--){
//              System.out.println("The value of i is: "+i);
//         }
//    }
//}