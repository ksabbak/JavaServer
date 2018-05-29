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
        map.put("/logs", new String[] {"GET"});
        map.put("/requests", new String[] {"HEAD"});
        map.put("/these", new String[] {"PUT"});
        map.put("/cookie", new String[] {"GET"});
        map.put("/eat-cookie", new String[] {"GET"});
        map.put("/cat-form", new String[] {"POST"});
        map.put("/coffee", new String[] {"GET"});
        map.put("/tea", new String[] {"GET"});
        map.put("/redirect", new String[] {"GET"});
        map.put("/method_options", new String[] {"GET", "PUT", "POST", "HEAD", "OPTIONS"});
        map.put("/method_options2", new String[] {"GET", "OPTIONS"});
        map.put("/form", new String[] {"POST"});
        map.put("/put-target", new String[] {"PUT"});
        map.put("/file1", new String[] {"GET"});
        map.put("/text-file.txt", new String[] {"GET"});

        return Collections.unmodifiableMap(map);
    }

    public static StatusCode validRequest(String method, String path) {
        String[] methods = routes.get(path);
        if(methods != null && Arrays.asList(methods).contains(method)) {
            return StatusCode.OK;
        }else {
            return StatusCode.NOT_FOUND;
        }
    }
}



//class <class name> {
//    private static final Map<Integer, String> tensNumberConversion = initMap();
//
//    private static Map<Integer, String> initMap() {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(2, "twenty");
//        map.put(3, "thirty");
//        map.put(4, "forty");
//        map.put(5, "fifty");
//        map.put(6, "sixty");
//        map.put(7, "seventy");
//        map.put(8, "eighty");
//        map.put(9, "ninety");
//        return Collections.unmodifiableMap(map);
//    }
//}