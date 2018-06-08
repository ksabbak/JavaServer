package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.server.HTTPMethod;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoutesTest {

    @Test
    public void methodsForPathExistingPath() {
        List<HTTPMethod> methods = Routes.methodsForPath("/");
        List<HTTPMethod> expected = new ArrayList<HTTPMethod>(){{
            add(HTTPMethod.GET);
            add(HTTPMethod.HEAD);
        }};
        assertArrayEquals(expected.toArray(), methods.toArray());
    }
}