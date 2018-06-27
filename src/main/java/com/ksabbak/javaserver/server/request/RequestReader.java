package com.ksabbak.javaserver.server.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestReader {

    public static String readHeader(BufferedReader in){
        String unparsedHeader = "";
        String line;
        Boolean blankLine = false;

        while (!blankLine && ((line = readLine(in)) != null)) {
            unparsedHeader += line + "\n";
            if (line.trim().isEmpty()) {
                blankLine = true;
            }
        }

        return unparsedHeader.trim();
    }


    public static List<Integer> readBody(BufferedReader in, int contentLength){
        List<Integer> unparsedBody = new ArrayList<Integer>();
        Integer character;
        int length = 0;

        while ((length < contentLength) && ((character = readChar(in)) != -1)) {
            unparsedBody.add(character);
            length++;
        }
        return unparsedBody;
    }


    private static String readLine(BufferedReader in){
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("READ LINE ERROR");
            e.printStackTrace();
            return "";
        }
    }

    private static int readChar(BufferedReader in){
        try {
            return in.read();
        } catch (IOException e) {
            System.out.println("READ ERROR");
            e.printStackTrace();
            return -1;
        }
    }

}
