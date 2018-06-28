package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.app.controller.NoPathController;
import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.StatusCode;
import com.ksabbak.javaserver.server.request.Request;
import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.storage.Persistable;
import com.ksabbak.javaserver.storage.Store;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class RouterTest {
    private Router router;

    @Before
    public void setup(){
        Persistable storage = new Store();
        router = new Router(storage);
        Routable routable = new Routes(router);
    }

    @Test
    public void addRouteTest(){
        assertFalse(router.controllers.containsKey("/test"));
        router.addRoute("/test", NoPathController.class);
        assertTrue(router.controllers.containsKey("/test"));
    }

    @Test
    public void respondExistingPathExistingMethod(){
        String header = "GET / HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);
        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondExistingPathInvalidMethod(){
        String header = "BREAK / HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        Response response = router.route(request);
        assertEquals(StatusCode.NOT_ALLOWED, response.getStatus());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondMissingPathIrrelevantMethod(){
        String header = "GET /trollinthedungeon HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        Response response = router.route(request);
        assertEquals(StatusCode.NOT_FOUND, response.getStatus());
        assertEquals("", response.getBody());
    }

}

