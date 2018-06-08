package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerFactoryTest {

    @Test
    public void getControllerIndex() {
        List<HTTPMethod> expectedMethods = new ArrayList<HTTPMethod>(){{
            add(HTTPMethod.GET);
            add(HTTPMethod.HEAD);
        }};
        Controller controller = ControllerFactory.getController("/");
        assertArrayEquals(expectedMethods.toArray(), controller.getMethods().toArray());
    }

    @Test
    public void getControllerFakePath() {
        Controller controller = ControllerFactory.getController("trollinthedungeon");
        assertArrayEquals(new ArrayList<HTTPMethod>().toArray(), controller.getMethods().toArray());
    }
}