package com.ksabbak.javaserver.app;
import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Routes {
    private static final Map<String, Object[]> routes = initMap();

    private static Map<String, Object[]> initMap() {
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        map.put("/", new Object[]{HTTPMethod.GET, HTTPMethod.HEAD});
        map.put("/tea", new Object[]{HTTPMethod.GET});
        map.put("/coffee", new Object[]{HTTPMethod.GET});
        map.put("/form", new Object[] {HTTPMethod.POST});

        return Collections.unmodifiableMap(map);
    }

    public static Object[] methodsForPath(String path){
        return routes.getOrDefault(path, new Object[]{});
    }

}