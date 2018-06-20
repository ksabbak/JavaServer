package com.ksabbak.javaserver.server;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
    private StatusCode statusCode;
    private Map<String, String> headers;
    private String body;

    private Response(ResponseBuilder builder){
        this.body = builder.body;
        this.headers = builder.headers;
        this.statusCode = builder.status;
    }

    public String getBody(){
        return body;
    }

    public StatusCode getStatus() { return statusCode; }

    public Map<String, String> getHeaders() { return Collections.unmodifiableMap(headers); }

    public static class ResponseBuilder {
        private final StatusCode status;
        private Map<String, String> headers = new HashMap<String, String>();
        private String body = "";

        public ResponseBuilder(StatusCode status){
            this.status = status;
        }

        public Response build(){
            return new Response(this);
        }

        public ResponseBuilder body(String body){
            this.body = body;
            contentLength(body);

            return this;
        }

        public ResponseBuilder options(List<String> allowedMethods){
            String methods = String.join(", ", allowedMethods);
            headers.put("Allow", methods);
            return this;
        }

        private void contentLength(String body){
            byte[] bytes = new byte[0];
            try {
                bytes = body.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            headers.put("Content-Length", Integer.toString(bytes.length));
        }


    }

}
