package com.ksabbak.javaserver.router;

import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.app.controller.ControllerFactory;
import com.ksabbak.javaserver.app.Responder;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.Response;

public class Router {
    public static Response respond(String path, HTTPMethod method){
        Controller controller =  ControllerFactory.getController(path);
        Responder responder = new Responder(controller);
        String status = responder.getStatusForMethod(method).statusAsString();
        String body = responder.getBodyForMethod(method);
        return new Response(status, body);
    }
}
