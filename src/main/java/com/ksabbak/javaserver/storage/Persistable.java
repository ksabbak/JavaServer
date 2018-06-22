package com.ksabbak.javaserver.storage;

public interface Persistable {

    String create(String key) throws KeyTakenException;

    String create(String key, String value) throws KeyTakenException;

    String update(String key, String value) throws KeyNotFoundException;

    String read(String key) throws KeyNotFoundException;

    void delete(String key) throws KeyNotFoundException;
}
