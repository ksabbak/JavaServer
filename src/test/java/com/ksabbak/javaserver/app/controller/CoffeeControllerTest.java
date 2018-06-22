package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeControllerTest {

    @Test
    public void getTest() {
        CoffeeController coffeeController = new CoffeeController();
        Store store = new Store();
        Response response = coffeeController.get("", store);

        assertEquals(StatusCode.TEAPOT, response.getStatus());
        assertEquals("I'm a teapot", response.getBody());
    }
}