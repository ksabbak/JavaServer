package com.ksabbak.javaserver.app;
import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.*;

public class Routes {
    private static final Map<String, List<HTTPMethod>> routes = initMap();

    private static Map<String, List<HTTPMethod>> initMap() {
        Map<String, List<HTTPMethod>> map = new HashMap<String, List<HTTPMethod>>();
        map.put("/", new ArrayList<HTTPMethod>() {{
            add(HTTPMethod.GET);
            add(HTTPMethod.HEAD);
        }});
        map.put("/tea", new ArrayList<HTTPMethod>() {{
            add(HTTPMethod.GET);
        }});
        map.put("/coffee", new ArrayList<HTTPMethod>(){{
            add(HTTPMethod.GET);
        }});

        return Collections.unmodifiableMap(map);
    }

    public static List<HTTPMethod> methodsForPath(String path){
        return routes.getOrDefault(path, new ArrayList<HTTPMethod>());
    }

}