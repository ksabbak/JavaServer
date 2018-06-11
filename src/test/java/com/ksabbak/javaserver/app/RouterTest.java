package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.app.controller.StatusCode;
import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.RequestData;
import com.ksabbak.javaserver.server.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouterTest {
    @Test
    public void respondExistingPathExistingMethod(){
        RequestData responseData = new RequestData(HTTPMethod.GET, "/", "");
        Response response = Router.respond(responseData);
        String expectedHeader = "HTTP/1.1 200 OK";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondExistingPathMissingMethod(){
        RequestData requestData = new RequestData(HTTPMethod.UNKNOWN, "/", "");
        Response response = Router.respond(requestData);
        String expectedHeader = "HTTP/1.1 404 Not Found";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }

    @Test
    public void respondMissingPathIrrelevantMethod(){
        RequestData requestData = new RequestData(HTTPMethod.GET, "/trollinthedungeon", "");
        Response response = Router.respond(requestData);
        String expectedHeader = "HTTP/1.1 404 Not Found";
        assertEquals(expectedHeader, response.getHeader());
        assertEquals("", response.getBody());
    }
}

