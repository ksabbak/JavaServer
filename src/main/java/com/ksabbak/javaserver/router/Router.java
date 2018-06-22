package com.ksabbak.javaserver.router;

import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.app.controller.NoPathController;
import com.ksabbak.javaserver.server.HTTPMethod;
import com.ksabbak.javaserver.server.request.Request;
import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.storage.Persistable;

import java.util.HashMap;
import java.util.Map;


public class Router {
    public Map<String, Class> controllers = new HashMap<String, Class>();
    public Persistable storage;

    public Router(Persistable storage){
        this.storage = storage;
    }
    public Response route(Request request){
        HTTPMethod method = request.getMethod();
        String path = request.getPath();
        String params = request.getBody();


        Class<Controller> controllerType = controllers.getOrDefault(path, NoPathController.class);
        Controller controller;
        try {
            controller = controllerType.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Instantiation");
            controller = new NoPathController();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccess");
            controller = new NoPathController();
        }
        Response response = getResponseForMethod(method, controller, params);

        return response;

    }

    public void addRoute(String path, Class controller){
        controllers.put(path, controller);
    }

    private Response getResponseForMethod(HTTPMethod method, Controller controller, String params){
        ResponseMethod responseMethod;
        switch(method){
            case GET:
                responseMethod = controller::get;
                break;
            case HEAD:
                responseMethod = controller::head;
                break;
            case POST:
                responseMethod = controller::post;
                break;
            case PUT:
                responseMethod = controller::put;
                break;
            case OPTIONS:
                responseMethod = controller::options;
                break;
            case DELETE:
                responseMethod = controller::delete;
                break;
            default:
                responseMethod = controller::unknown;
        }
        return responseMethod.handle(params, storage);
    }



    @FunctionalInterface
    interface ResponseMethod{
        Response handle(String params, Persistable storage);
    }

}
