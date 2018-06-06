package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.HTTPMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerFactoryTest {

    @Test
    public void getControllerIndex() {
        Object[] expectedMethods = new Object[] {HTTPMethod.GET, HTTPMethod.HEAD};
        Controller controller = ControllerFactory.getController("/");
        assertArrayEquals(expectedMethods, controller.getMethods());
    }

    @Test
    public void getControllerFakePath() {
        Controller controller = ControllerFactory.getController("trollinthedungeon");
        assertArrayEquals(new Object[]{}, controller.getMethods());
    }
}