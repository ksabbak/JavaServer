package com.ksabbak.javaserver.server;

public class RequestHeader {
    private final int METHOD_POSITION = 0;
    private final int PATH_POSITION = 1;

    public String text;
    public HTTPMethod method;
    public String path;

    public RequestHeader(String unparsedHeader){
        text = unparsedHeader;
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
            e.printStackTrace();
            formattedMethod = HTTPMethod.UNKNOWN;
        }
        return formattedMethod;
    }
}
