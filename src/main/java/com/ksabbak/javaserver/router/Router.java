package com.ksabbak.javaserver.router;

import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.app.controller.ControllerFactory;
import com.ksabbak.javaserver.app.Responder;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.RequestData;
import com.ksabbak.javaserver.server.Response;

public class Router {
    public static Response respond(RequestData requestData){
        HTTPMethod method = requestData.getMethod();
        String path = requestData.getPath();
        String params = requestData.getBody();

        System.out.println("Inside the router");
        System.out.println(path);
        System.out.println(method);

        Controller controller =  ControllerFactory.getController(path);
        Responder responder = new Responder(controller);
        String status = responder.getStatusForMethod(method).statusAsString();
        String body = responder.getBodyForMethod(method, params);
        return new Response(status, body);
    }
}
