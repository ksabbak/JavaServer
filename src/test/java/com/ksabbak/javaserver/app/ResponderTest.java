package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.server.HTTPMethod;
import org.junit.Test;
import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.app.controller.StatusCode;

import java.util.ArrayList;
import java.util.List;

public class ResponderTest {

    @Test
    public void controllerTestWithOutGET(){
        Controller controller = new Controller();
        Responder responder = new Responder(controller);
        assert(StatusCode.NOT_FOUND == responder.getGetStatus());
    }

    @Test
    public void controllerTestWithGET(){
        List<HTTPMethod> methods = new ArrayList<HTTPMethod>(){{
            add(HTTPMethod.GET);
        }};
        Controller controller = new Controller(methods);
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
        List<HTTPMethod> methods = new ArrayList<HTTPMethod>(){{
            add(HTTPMethod.GET);
            add(HTTPMethod.HEAD);
        }};
        Controller controller = new Controller(methods);
        Responder responder = new Responder(controller);
        assert(StatusCode.OK == responder.getHeadStatus());
    }

    @Test
    public void controllerTestGetStatusForMethodHasMethod(){
        List<HTTPMethod> methods = new ArrayList<HTTPMethod>(){{
            add(HTTPMethod.GET);
        }};
        Controller controller = new Controller(methods);
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
