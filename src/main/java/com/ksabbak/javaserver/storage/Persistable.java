package com.ksabbak.javaserver.storage;

public interface Persistable {

    String create(String key) throws Exception;

    String create(String key, String value) throws Exception;

    String update(String key, String value) throws Exception;

    String read(String key) throws Exception;

    String delete(String key) throws Exception;
}
