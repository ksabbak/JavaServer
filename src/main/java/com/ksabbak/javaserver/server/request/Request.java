package com.ksabbak.javaserver.server.request;

import com.ksabbak.javaserver.server.HTTPMethod;

import java.io.BufferedReader;
import java.util.List;

public class Request {
    private HTTPMethod method;
    private String path;
    private String body;

    private Request(HTTPMethod method, String path, String body){
        this.method = method;
        this.path = path;
        this.body = body;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    public String getPath(){
        return path;
    }

    public String getBody() {
        return body;
    }

    public static class RequestParser {
        private final int METHOD_POSITION = 0;
        private final int PATH_POSITION = 1;
        private final int CONTENT_LENGTH_POSITION = 1;
        private final String CONTENT_LENGTH = "Content-Length";

        private String text;
        private HTTPMethod method;
        private String path;
        private int contentLength = 0;
        private String body = "";

        public RequestParser(BufferedReader in) {
            String unparsedHeader = RequestReader.readHeader(in);
            if (!unparsedHeader.isEmpty()) {
                text = unparsedHeader;
                method = HTTPMethod.verifyMethod(pullElement(METHOD_POSITION));
                path = pullElement(PATH_POSITION);
                if (text.contains(CONTENT_LENGTH)) {
                    contentLength = pullContentLength();
                    addBody(in);
                }
            }
        }

        public Request parse(){
            return new Request(method, path, body);
        }

        private void addBody(BufferedReader in){
            List<Integer> unparsedBody = RequestReader.readBody(in, contentLength);
            body = parseBody(unparsedBody);
        }

        private String parseBody(List<Integer> unparsedRequest){
            String parsedRequest = "";
            for (Integer charOfUnparsedRequest : unparsedRequest) {
                int simpleInt = charOfUnparsedRequest;
                char nextChar = (char) simpleInt;
                String nextCharAsString = (String.valueOf(nextChar));
                parsedRequest += nextCharAsString;
            }
            return parsedRequest;
        }

        private String pullElement(int elementPosition){
            String[] components = text.split(" ");
            return components[elementPosition];
        }

        private int pullContentLength(){
            String[] components = text.split("\\R+");
            for (String component : components) {
                if (component.contains(CONTENT_LENGTH)) {
                    String[] words = component.split(" ");
                    return Integer.parseInt(words[CONTENT_LENGTH_POSITION]);
                }
            }
            return 0;
        }
    }
}
