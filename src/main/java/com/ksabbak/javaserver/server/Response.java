package com.ksabbak.javaserver.server;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class Response {
    private final String CRLF = "\r\n\r\n";

    private String header;
    private String body;

    private Response(ResponseBuilder builder){
        this.header = builder.getHeader();
        this.body = builder.body;
    }

    public String getResponse(){
        return header + CRLF + body;
    }

    public String getHeader(){
        return header;
    }

    public String getBody(){
        return body;
    }

    public static class ResponseBuilder {
        private final String NEW_LINE = "\n";

        private final String statusLine;
        private String contentLength = "";
        private String allow = "";
        private String body = "";

        public ResponseBuilder(StatusCode status){
            statusLine = startHeader(status);
        }

        public Response build(){
            return new Response(this);
        }

        public ResponseBuilder body(String body){
            this.body = body;
            contentLength = contentLength(body);

            return this;
        }

        public ResponseBuilder options(List<String> allowedMethods){
            String allow = "Allow: ";
            String methods = String.join(", ", allowedMethods);
            this.allow = allow + methods;
            return this;
        }

        protected String getHeader(){
            String fullHeader = "";
            String[] headerLines = new String[] {
                    statusLine,
                    allow,
                    contentLength
            };

            for (String line : headerLines) {
                if(!line.isEmpty()) {
                    fullHeader += (line + NEW_LINE);
                }
            }

            return fullHeader.trim();
        }

        private String startHeader(StatusCode status){
            return "HTTP/1.1 " + status.statusAsString();
        }

        private String contentLength(String body){
            byte[] bytes = new byte[0];
            try {
                bytes = body.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "Content-Length: " + bytes.length;
        }


    }

}
