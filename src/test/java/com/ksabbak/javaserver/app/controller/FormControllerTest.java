package com.ksabbak.javaserver.app.controller;

import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormControllerTest {

    @Test
    public void postTest() {
        Store store = new Store();
        FormController formController = new FormController();
        Response response = formController.post("player1=x&player2=o", store);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("player1=x\nplayer2=o", response.getBody());
    }
}