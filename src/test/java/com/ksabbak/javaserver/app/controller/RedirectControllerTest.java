package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedirectControllerTest {

    @Test
    public void getTest() {
        Store store = new Store();
        RedirectController redirectController = new RedirectController();
        Response response = redirectController.get("", store);
        assertEquals(StatusCode.FOUND, response.getStatus());
        assertEquals("/", response.getHeaders().get("Location"));
    }
}