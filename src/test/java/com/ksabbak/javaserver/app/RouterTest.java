package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.app.controller.NoPathController;
import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.Request;
import com.ksabbak.javaserver.server.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouterTest {
    private Router router;

    @Before
    public void setup(){
        router = new Router();
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
        Request responseData = new Request(HTTPMethod.GET, "/", "");
        Response response = router.route(responseData);
        String expectedHeader = "HTTP/1.1 200 OK";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondExistingPathMissingMethod(){
        Request request = new Request(HTTPMethod.UNKNOWN, "/", "");
        Response response = router.route(request);
        String expectedHeader = "HTTP/1.1 405 Method Not Allowed";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondMissingPathIrrelevantMethod(){
        Request request = new Request(HTTPMethod.GET, "/trollinthedungeon", "");
        Response response = router.route(request);
        String expectedHeader = "HTTP/1.1 404 Not Found";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

}

