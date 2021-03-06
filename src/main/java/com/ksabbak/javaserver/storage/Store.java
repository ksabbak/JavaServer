package com.ksabbak.javaserver.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Store implements Persistable {
    private Map<String, String> store;

    public Store(){
        store = new HashMap<String, String>();
    }

    @Override
    synchronized public String create(String key) throws KeyTakenException{
        return create(key, "");
    }

    @Override
    synchronized public String create(String key, String value) throws KeyTakenException {
        if (store.get(key) != null) throw new KeyTakenException();
        store.put(key, value);
        return key;
    }

    @Override
    synchronized public String update(String key, String value) throws KeyNotFoundException{
        if (store.get(key) == null) throw new KeyNotFoundException();
        store.put(key, value);
        return key;
    }

    @Override
    public Optional<String> read(String key){
        String value = store.get(key);
        return Optional.ofNullable(value);
    }

    @Override
    synchronized public void delete(String key) throws KeyNotFoundException{
        String value = store.remove(key);
        if (value == null){
            throw new KeyNotFoundException();
        }
    }
}
