package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.KeyTakenException;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatFormDataControllerTest {
    private Store store;
    private Store emptyStore;
    private CatFormDataController catFormDataController;

    @Before
    public void setUp() {
        store = new Store();
        emptyStore = new Store();
        catFormDataController = new CatFormDataController();

        try {
            store.create("data", "Pepper");
        } catch (KeyTakenException e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    public void getWithDataTest() {
        Response response = catFormDataController.get("", store);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("data=Pepper", response.getBody());
    }

    public void getNoDataTest() {
        Response response = catFormDataController.get("", emptyStore);

        assertEquals(StatusCode.NOT_FOUND, response.getStatus());
        assertEquals("", response.getBody());
    }

    @Test
    public void putWithDataTest() {
        Response response = catFormDataController.put("data=Wash", store);

        assertEquals(StatusCode.OK, response.getStatus());

        response = catFormDataController.get("", store);
        assertEquals("data=Wash", response.getBody());
    }

    @Test
    public void putNoDataTest() {
        Response response = catFormDataController.put("data=Zoe", emptyStore);

        assertEquals(StatusCode.CONFLICT, response.getStatus());
        assertEquals("", response.getBody());
    }

    @Test
    public void deleteWithDataTest() {
        Response response = catFormDataController.delete("", store);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("", response.getBody());
    }

    @Test
    public void deleteNoDataTest() {
        Response response = catFormDataController.delete("", emptyStore);

        assertEquals(StatusCode.NOT_ALLOWED, response.getStatus());
    }
}
