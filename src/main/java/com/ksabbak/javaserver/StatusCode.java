package com.ksabbak.javaserver;

public enum StatusCode {
    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    FOUND(302, "Found"),
    UNAUTHORIZED(401, "Unauthorized"),
    NOT_FOUND(404, "Not Found"),
    NOT_ALLOWED(405, "Method Not Allowed"),
    RANGE(416, "Range Not Satisfiable"),
    TEAPOT(418, "I'm a teapot");

    public int code;
    public String text;

    private StatusCode(int code, String text){
        this.code = code;
        this.text = text;
    }

    public String getWholeStatus(){
        return Integer.toString(this.code) + " " + this.text;
    }



}


//200 OK
//201 Created
//202 Accepted
//203 Non-Authoritative Information
//204 No Content
//205 Reset Content
//206 Partial Content
//300 Multiple Choices
//301 Moved Permanently
//302 Found
//303 See Other
//304 Not Modified
//307 Temporary Redirect
//308 Permanent Redirect
//400 Bad Request
//401 Unauthorized
//403 Forbidden
//404 Not Found
//405 Method Not Allowed
//406 Not Acceptable
//407 Proxy Authentication Required
//408 Request Timeout
//409 Conflict
//410 Gone
//411 Length Required
//412 Precondition Failed
//413 Payload Too Large
//414 URI Too Long
//415 Unsupported Media Type
//416 Range Not Satisfiable
//417 Expectation Failed
//418 I'm a teapot
//422 Unprocessable Entity
//426 Upgrade Required
//428 Precondition Required
//429 Too Many Requests
//431 Request Header Fields Too Large
//451 Unavailable For Legal Reasons
//500 Internal Server Error
//501 Not Implemented
//502 Bad Gateway
//503 Service Unavailable
//504 Gateway Timeout
//505 HTTP Version Not Supported
//511 Network Authentication Required