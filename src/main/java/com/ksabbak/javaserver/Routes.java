package com.ksabbak.javaserver;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Routes {
    private static final Map<String, String[]> routes = initMap();

    private static Map<String, String[]> initMap(){
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("/", new String[] {"GET", "HEAD"});

        return Collections.unmodifiableMap(map);
    }

    public static StatusCode validRequest(String method, String path) {
        String[] methods = routes.get(path);
        if(methods != null && Arrays.asList(methods).contains(method)){
            return StatusCode.OK;
        }else {
            return StatusCode.NOT_FOUND;
        }
    }
}