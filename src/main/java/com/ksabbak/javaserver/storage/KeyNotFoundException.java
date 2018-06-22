package com.ksabbak.javaserver.storage;

public class KeyNotFoundException extends Exception {

    public KeyNotFoundException(){}

    public KeyNotFoundException(String message){
        super(message);
    }
}
