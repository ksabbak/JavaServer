package com.ksabbak.javaserver.router;

import com.ksabbak.javaserver.app.Routable;
import com.ksabbak.javaserver.app.Routes;
import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.app.controller.NoPathController;
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
    public void setup() {
        Persistable storage = new Store();
        router = new Router(storage);
        Routable routable = new Routes(router);
        router.addRoute("/test", TestController.class);
    }

    @Test
    public void addRouteTest() {
        assertFalse(router.controllers.containsKey("/add-test"));
        router.addRoute("/add-test", NoPathController.class);
        assertTrue(router.controllers.containsKey("/add-test"));
    }

    @Test
    public void respondExistingPathGETMethod() {
        String header = "GET /test HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("GET", response.getBody());
    }

    @Test
    public void respondExistingPathPOSTMethod() {
        String header = "POST /test HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("POST", response.getBody());
    }

    @Test
    public void respondExistingPathPUTMethod() {
        String header = "PUT /test HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("PUT", response.getBody());
    }

    @Test
    public void respondExistingPathDELETEMethod() {
        String header = "DELETE /test HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("DELETE", response.getBody());
    }

    @Test
    public void respondExistingPathOPTIONSMethod() {
        String header = "OPTIONS /test HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("OPTIONS", response.getBody());
    }

    @Test
    public void respondExistingPathHEADMethod() {
        String header = "HEAD /test HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request responseData = new Request.RequestParser(in).parse();

        Response response = router.route(responseData);

        assertEquals(StatusCode.OK, response.getStatus());
        assertEquals("HEAD", response.getBody());
    }

    @Test
    public void respondMissingPathIrrelevantMethod() {
        String header = "GET /trollinthedungeon HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        Response response = router.route(request);
        assertEquals(StatusCode.NOT_FOUND, response.getStatus());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondExistingPathInvalidMethod() {
        String header = "BREAK / HTTP/1.1";
        BufferedReader in = new BufferedReader(new StringReader(header));
        Request request = new Request.RequestParser(in).parse();

        Response response = router.route(request);
        assertEquals(StatusCode.NOT_ALLOWED, response.getStatus());
        assertEquals("", response.getBody());
    }
}