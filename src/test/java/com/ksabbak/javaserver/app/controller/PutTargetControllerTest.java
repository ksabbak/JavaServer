package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PutTargetControllerTest {
    private PutTargetController putTargetController;
    private Store store;

    @Before
    public void setUp(){
        putTargetController = new PutTargetController();
        store = new Store();
    }

    @Test
    public void putTest() {
        Response response = putTargetController.put("\"My\"=test", store);
        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("My=test", response.getBody());

        response = putTargetController.put("\"My\"=otherTest", store);
        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("My=otherTest", response.getBody());
    }

}