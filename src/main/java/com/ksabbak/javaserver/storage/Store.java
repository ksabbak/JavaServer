package com.ksabbak.javaserver.storage;

import java.util.HashMap;
import java.util.Map;

public class Store implements Persistable {
    private Map<String, String> store;

    public Store(){
        store = new HashMap<String, String>();
    }

    @Override
    synchronized public String create(String key) throws Exception {
        return create(key, "");
    }

    @Override
    synchronized public String create(String key, String value) throws Exception {
        if (store.get(key) != null) throw new Exception();
        store.put(key, value);
        return key;
    }

    @Override
    synchronized public String update(String key, String value) throws Exception{
        if (store.get(key) == null) throw new Exception();
        store.put(key, value);
        return key;
    }

    @Override
    public String read(String key) throws Exception{
        String value = store.get(key);
        if (value == null) throw new Exception();
        return value;
    }

    @Override
    synchronized public String delete(String key) throws Exception{
        String value = store.remove(key);
        if (value == null){
            throw new Exception();
        }
        return value;
    }
}
