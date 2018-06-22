package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodOptions2ControllerTest {
    private MethodOptions2Controller methodOptions2Controller;
    private Store store;

    @Before
    public void setUp(){
        methodOptions2Controller = new MethodOptions2Controller();
        store = new Store();
    }


    @Test
    public void optionsTest() {
        Response response = methodOptions2Controller.options("", store);

        assertEquals(StatusCode.OK, response.getStatus());
        assertTrue(response.getHeaders().get("Allow").contains("GET"));
        assertTrue(response.getHeaders().get("Allow").contains("OPTIONS"));
        assertTrue(response.getHeaders().get("Allow").contains("HEAD"));

    }

    @Test
    public void getTest() {
        Response response = methodOptions2Controller.get("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void headTest() {
        Response response = methodOptions2Controller.head("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }
}