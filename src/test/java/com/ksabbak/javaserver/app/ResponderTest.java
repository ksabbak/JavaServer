package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.server.HTTPMethod;
import org.junit.Test;
import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.app.controller.StatusCode;

public class ResponderTest {

    @Test
    public void controllerTestWithOutGET(){
        Controller controller = new Controller();
        Responder responder = new Responder(controller);
        assert(StatusCode.NOT_FOUND == responder.getGetStatus());
    }

    @Test
    public void controllerTestWithGET(){
        Controller controller = new Controller(new Object[] {HTTPMethod.GET});
        Responder responder = new Responder(controller);
        assert(StatusCode.OK == responder.getGetStatus());
    }

    @Test
    public void controllerTestWithOutHEAD(){
        Controller controller = new Controller();
        Responder responder = new Responder(controller);
        assert(StatusCode.NOT_FOUND == responder.getHeadStatus());
    }

    @Test
    public void controllerTestWithHEAD(){
        Controller controller = new Controller(new Object[] {HTTPMethod.GET, HTTPMethod.HEAD});
        Responder responder = new Responder(controller);
        assert(StatusCode.OK == responder.getHeadStatus());
    }

    @Test
    public void controllerTestGetStatusForMethodHasMethod(){
        Controller controller = new Controller(new Object[] {HTTPMethod.GET});
        Responder responder = new Responder(controller);
        assert(StatusCode.OK == responder.getStatusForMethod(HTTPMethod.GET));
    }

    @Test
    public void controllerTestGetStatusForMethodNoMethod(){
        Controller controller = new Controller();
        Responder responder = new Responder(controller);
        assert(StatusCode.NOT_FOUND == responder.getStatusForMethod(HTTPMethod.GET));
    }

}
