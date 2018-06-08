package com.ksabbak.javaserver.server;
import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.app.controller.StatusCode;

import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int portNumber = 5000;

        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        while (true){

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String unparsedHeader = "";
                String line;
                Boolean blankLine = false;

                while(!blankLine && ((line = in.readLine()) != null)){
                    unparsedHeader += line;
                    if (line.trim().isEmpty()){
                        blankLine = true;
                    }
                }

                RequestHeader requestHeader = new RequestHeader(unparsedHeader);
                Response httpResponse = Router.respond(requestHeader.path, requestHeader.method);
                String formattedResponse = httpResponse.formattedResponse();
                System.out.println(formattedResponse);
                System.out.println(requestHeader.method);

                socket.getOutputStream().write(formattedResponse.getBytes("UTF-8"));
            }
        }
    }
}