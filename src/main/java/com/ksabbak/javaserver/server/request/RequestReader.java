package com.ksabbak.javaserver.server.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestReader {
    
    private BufferedReader in;
    public RequestReader(BufferedReader in){
        this.in = in;
    }

    public Request read(){
        String unparsedHeader = readHeader();
        RequestParser requestParser = new RequestParser(unparsedHeader);
        List<Integer> unparsedBody = readBody(requestParser.getContentLength());
        requestParser.addBody(unparsedBody);
        return requestParser.parse();
    }

    private String readHeader(){
        String unparsedHeader = "";
        String line;
        Boolean blankLine = false;

        while (!blankLine && ((line = readLine()) != null)) {
            unparsedHeader += line + "\n";
            if (line.trim().isEmpty()) {
                blankLine = true;
            }
        }
        
        return unparsedHeader;
    }
    
    
    private List<Integer> readBody(int contentLength){
        List<Integer> unparsedBody = new ArrayList<Integer>();
        Integer character;
        int length = 0;

        while ((length < contentLength) && ((character = readChar()) != -1)) {
            unparsedBody.add(character);
            length++;
        }
        return unparsedBody;
    }
    
    private String readLine(){
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("READ LINE ERROR");
            e.printStackTrace();
            return "";
        }
    }

    private int readChar(){
        try {
            return in.read();
        } catch (IOException e) {
            System.out.println("READ ERROR");
            e.printStackTrace();
            return -1;
        }
    }

}
