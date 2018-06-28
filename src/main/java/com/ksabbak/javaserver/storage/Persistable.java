package com.ksabbak.javaserver.storage;

import java.util.Optional;

public interface Persistable {

    String create(String key) throws KeyTakenException;

    String create(String key, String value) throws KeyTakenException;

    String update(String key, String value) throws KeyNotFoundException;

    Optional<String> read(String key);

    void delete(String key) throws KeyNotFoundException;
}
