package com.ksabbak.javaserver.server;

public enum HTTPMethod {
    GET, HEAD, POST, PUT, OPTIONS, UNKNOWN;

    public static HTTPMethod verifyMethod(String potentialMethod){
        try {
            return HTTPMethod.valueOf(potentialMethod);
        } catch (IllegalArgumentException e){
            return UNKNOWN;
        }
    }
}
