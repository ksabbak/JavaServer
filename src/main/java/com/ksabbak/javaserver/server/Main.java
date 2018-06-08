package com.ksabbak.javaserver.server;
import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.app.controller.StatusCode;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        int portNumber = 5000;

        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        while (true){

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                List<Integer> unparsedHeader = new ArrayList<Integer>();
                Integer bit;
//                Boolean blankLine = false;

                while((bit = in.read()) != -1){
                    unparsedHeader.add(bit);
                    System.out.println(bit);
                }

                RequestHeader requestHeader = new RequestHeader(unparsedHeader);
                Response httpResponse = Router.respond(requestHeader.path, requestHeader.method);
                String formattedResponse = httpResponse.formattedResponse();

                socket.getOutputStream().write(formattedResponse.getBytes("UTF-8"));
            }
        }
    }
}