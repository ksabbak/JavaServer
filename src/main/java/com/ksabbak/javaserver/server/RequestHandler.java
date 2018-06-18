package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.router.Router;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler implements Runnable{
    private Socket socket;
    private Router router;
    private Server server;
    private InputStream inputStream;


    public RequestHandler(Socket socket, Router router, Server server) {
        this.socket = socket;
        this.router = router;
        this.server = server;
        System.out.println("HELLO");
    }

    public void run(){
            socketGetInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String unparsedHeader = "";
            String line;
            Boolean blankLine = false;

//            server.turnListeningOff();
            while (!blankLine && ((line = readLine(in)) != null)) {
                unparsedHeader += line + "\n";
                if (line.trim().isEmpty()) {
                    blankLine = true;
                }
            }
            RequestParser requestParser = new RequestParser(unparsedHeader);
        System.out.println(":)");

        List<Integer> unparsedBody = new ArrayList<Integer>();
            Integer character;
            int length = 0;

            while ((length < requestParser.getContentLength()) && ((character = read(in)) != -1)) {
                System.out.println("?????");
                unparsedBody.add(character);
                length++;
            }
        System.out.println(":(");

            requestParser.addBody(unparsedBody);
            Request request = requestParser.parse();

            Response httpResponse = router.route(request);
            String formattedResponse = httpResponse.getResponse();

            writeResponse(formattedResponse, socket);
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("SOCKET WON'T CLOSE ERROR");
            e.printStackTrace();
        }
    }

    private String readLine(BufferedReader in){
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("READ LINE ERROR");
            e.printStackTrace();
            return "";
        }
    }

    private int read(BufferedReader in){
        try {
            return in.read();
        } catch (IOException e) {
            System.out.println("READ ERROR");
            e.printStackTrace();
            return -1;
        }
    }

    private void writeResponse(String formattedResponse, Socket socket){
        try {
            socket.getOutputStream().write(formattedResponse.getBytes("UTF-8"));
        } catch (IOException e) {
            System.out.println("WRITE RESPONSE ERROR");
            e.printStackTrace();
        }
    }

    private void socketGetInputStream(){
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private Socket serverSocketAccept(){
//        try {
//            return serverSocket.accept();
//        } catch (IOException e) {
//            System.out.println("SERVER SOCKET ACCEPT ERROR");
//            e.printStackTrace();
//            return new Socket();
//        }
//    }

}


