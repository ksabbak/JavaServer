package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.app.controller.StatusCode;
import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.Arrays;
import java.util.List;

public class Responder {
    protected StatusCode statusGet = StatusCode.NOT_FOUND;
    protected StatusCode statusHead = StatusCode.NOT_FOUND;

    private Controller controller;

    public Responder(Controller controller){
        this.controller = controller;
        List<HTTPMethod> methods = controller.getMethods();
        if (methods.contains(HTTPMethod.GET)){
            setGetStatus();
        }
        if (methods.contains(HTTPMethod.HEAD)){
            setHeadStatus();
        }
    }

    public final StatusCode getStatusForMethod(HTTPMethod method){
        switch(method){
            case GET:
                return getGetStatus();
            case HEAD:
                return getHeadStatus();
            default:
                return StatusCode.NOT_FOUND;
        }
    }

    public final String getBodyForMethod(HTTPMethod method){
        switch(method){
            case GET:
                return getGetBody();
            default:
                return "";
        }
    }

    public StatusCode getGetStatus(){
        return statusGet;
    }

    private void setGetStatus(){
        statusGet =  controller.statusGet();
    }

    public StatusCode getHeadStatus(){
        return statusHead;
    }

    private void setHeadStatus(){
        statusHead = StatusCode.OK;
    }

    public String getGetBody(){
        return controller.bodyGet();
    }

}
