package com.ksabbak.javaserver.server;

import java.util.Map;

public class ResponseFormatter {
    private static final String CRLF = "\r\n\r\n";
    private static final String NEW_LINE = "\n";

    public static String format(Response response){
        String header = firstHeaderLine(response.getStatus()) + restOfHeader(response.getHeaders());
        String body = response.getBody();
        return header + CRLF + body;
    }

    private static String restOfHeader(Map<String, String> headers){
        String headerLines = "";
        for(Map.Entry<String, String> pair : headers.entrySet()){
            String formattedLine =NEW_LINE + pair.getKey() + ": " + pair.getValue();
            headerLines += formattedLine;
        }

        return headerLines;
    }

    private static String firstHeaderLine(StatusCode status){
        return "HTTP/1.1 " + status.statusAsString();
    }

}

