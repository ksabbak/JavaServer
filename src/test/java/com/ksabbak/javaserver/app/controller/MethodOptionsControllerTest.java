package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodOptionsControllerTest {
    private MethodOptionsController methodOptionsController;
    private Store store;

    @Before
    public void setUp(){
        methodOptionsController = new MethodOptionsController();
        store = new Store();
    }


    @Test
    public void optionsTest() {
        Response response = methodOptionsController.options("", store);

        assertEquals(StatusCode.OK, response.getStatus());
        assertTrue(response.getHeaders().get("Allow").contains("GET"));
        assertTrue(response.getHeaders().get("Allow").contains("HEAD"));
        assertTrue(response.getHeaders().get("Allow").contains("OPTIONS"));
        assertTrue(response.getHeaders().get("Allow").contains("PUT"));
        assertTrue(response.getHeaders().get("Allow").contains("POST"));

    }

    @Test
    public void getTest() {
        Response response = methodOptionsController.get("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void headTest() {
        Response response = methodOptionsController.head("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void postTest() {
        Response response = methodOptionsController.post("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void putTest() {
        Response response = methodOptionsController.put("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }
}