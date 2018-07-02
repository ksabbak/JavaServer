package com.ksabbak.javaserver.server.request;

import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.server.Response;
import com.ksabbak.javaserver.server.ResponseFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class HTTPConnection implements Runnable{
    private Socket socket;
    private Router router;
    private InputStream inputStream;


    public HTTPConnection(Socket socket, Router router) {
        this.socket = socket;
        this.router = router;
    }

    public void run(){
            socketGetInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            Request request = new Request.RequestParser(in).parse();
            Response httpResponse = router.route(request);
            String formattedResponse = ResponseFormatter.format(httpResponse);

            writeResponse(formattedResponse, socket);
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("SOCKET WON'T CLOSE ERROR");
            e.printStackTrace();
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

}


