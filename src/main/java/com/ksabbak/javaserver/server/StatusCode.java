package com.ksabbak.javaserver.server;

public enum StatusCode {
    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED(301, "Moved Permanently"),
    FOUND(302, "Found"),
    TEMP_REDIRECT(307, "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "Permanent Redirect"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    NOT_ALLOWED(405, "Method Not Allowed"),
    TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    LENGTH_REQUIRED(408, "Length Required"),
    RANGE(416, "Range Not Satisfiable"),
    TEAPOT(418, "I'm a teapot"),
    SERVER_ERROR(500, "Internal Server Error");


    public int code;
    public String text;

    private StatusCode(int code, String text){
        this.code = code;
        this.text = text;
    }

    public String statusAsString(){
        return Integer.toString(this.code) + " " + this.text;
    }

}
