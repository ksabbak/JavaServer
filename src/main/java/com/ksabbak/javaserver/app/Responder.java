package com.ksabbak.javaserver.app;

import com.ksabbak.javaserver.app.controller.StatusCode;
import com.ksabbak.javaserver.app.controller.Controller;
import com.ksabbak.javaserver.server.HTTPMethod;

import java.util.List;

public class Responder {
    private StatusCode statusGet = StatusCode.NOT_FOUND;
    private StatusCode statusHead = StatusCode.NOT_FOUND;
    private StatusCode statusPost = StatusCode.NOT_FOUND;
    private StatusCode statusPut = StatusCode.NOT_FOUND;

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
        if (methods.contains(HTTPMethod.POST)){
            setPostStatus();
        }
        if (methods.contains(HTTPMethod.PUT)){
            setPutStatus();
        }
    }

    public final StatusCode getStatusForMethod(HTTPMethod method){
        switch(method){
            case GET:
                return getGetStatus();
            case HEAD:
                return getHeadStatus();
            case POST:
                return getPostStatus();
            case PUT:
                return getPutStatus();
            default:
                return StatusCode.NOT_FOUND;
        }
    }

    public final String getBodyForMethod(HTTPMethod method){
        return getBodyForMethod(method, "");
    }

    public final String getBodyForMethod(HTTPMethod method, String params){
        switch(method){
            case GET:
                return getGetBody();
            case POST:
                return getPostBody(params);
            case PUT:
                return getPutBody(params);
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

    public String getGetBody(){
        return controller.bodyGet();
    }

    public StatusCode getHeadStatus(){
        return statusHead;
    }

    private void setHeadStatus(){
        statusHead = controller.statusHead();
    }

    public StatusCode getPostStatus(){
        return statusPost;
    }

    private void setPostStatus(){
        statusPost = controller.statusPost();
        System.out.println(statusPost);
    }

    private String getPostBody(String params){
        return controller.bodyPost(params);
    }

    public StatusCode getPutStatus(){
        return statusPut;
    }

    private void setPutStatus(){
        statusPut = controller.statusPut();
        System.out.println(statusPut);
    }

    private String getPutBody(String params){
        return controller.bodyPut(params);
    }
}
