package com.ksabbak.javaserver;

public class Header {
    private final int METHOD_POSITION = 0;
    private final int PATH_POSITION = 1;

    public String text;
    public String method;
    public String path;

    public Header(String unparsedHeader){
        text = unparsedHeader;
        method = pullElement(METHOD_POSITION);
        path = pullElement(PATH_POSITION);
    }

    private String pullElement(int elementPosition){
        String[] components = text.split(" ");
        return components[elementPosition];
    }
}
