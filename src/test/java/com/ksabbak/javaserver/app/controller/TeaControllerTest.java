package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeaControllerTest {

    @Test
    public void getTest() {
        TeaController teaController = new TeaController();
        Response response = teaController.get("", new Store());
        assertEquals(StatusCode.OK, response.getStatus());
    }
}