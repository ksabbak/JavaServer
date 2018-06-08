package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.app.controller.StatusCode;
import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouterTest {
    @Test
    public void respondExistingPathExistingMethod(){
        Response response = Router.respond("/", HTTPMethod.GET);
        String expectedHeader = "HTTP/1.1 200 OK";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondExistingPathMissingMethod(){
        Response response = Router.respond("/", HTTPMethod.UNKNOWN);
        String expectedHeader = "HTTP/1.1 404 Not Found";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondMissingPathIrrelevantMethod(){
        Response response = Router.respond("/trollinthedungeon", HTTPMethod.GET);
        String expectedHeader = "HTTP/1.1 404 Not Found";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }
}

