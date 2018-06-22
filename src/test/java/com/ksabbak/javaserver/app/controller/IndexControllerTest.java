package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IndexControllerTest {
    private IndexController indexController;
    private Store store;

    @Before
    public void setUp(){
        indexController = new IndexController();
        store = new Store();
    }

    @Test
    public void getTest() {
        Response response = indexController.get("", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void headTest() {
        Response response = indexController.head("", store);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("", response.getBody());
    }
}