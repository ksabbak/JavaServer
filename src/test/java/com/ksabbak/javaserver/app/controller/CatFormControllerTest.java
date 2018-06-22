package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.KeyTakenException;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatFormControllerTest {

    private Store store;
    private Store emptyStore;
    private CatFormController catFormController;

    @Before
    public void setUp() {
        store = new Store();
        emptyStore = new Store();
        catFormController = new CatFormController();

        try {
            store.create("data", "Pepper");
        } catch (KeyTakenException e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    public void postGoodDataTest(){
        Response response = catFormController.post("data=Wendy", emptyStore);

        assertEquals(StatusCode.CREATED, response.getStatus());
        assertEquals("/cat-form/data", response.getHeaders().get("Location"));
    }

    @Test
    public void postBadDataTest(){
        Response response = catFormController.post("cat=Dexter", store);

        assertEquals(StatusCode.OK, response.getStatus());
    }

    @Test
    public void postExistingDataTest(){
        Response response = catFormController.post("data=Desmond", store);

        assertEquals(StatusCode.CONFLICT, response.getStatus());
    }
}