package com.ksabbak.javaserver.storage;

public class KeyTakenException extends Exception {

    public KeyTakenException(){}

    public KeyTakenException(String message){
        super(message);
    }
}
