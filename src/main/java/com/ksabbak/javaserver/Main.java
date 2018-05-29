package com.ksabbak.javaserver;
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
                Boolean crlf = false;

                while(!crlf && ((line = in.readLine()) != null)){
                    unparsedHeader += line;
                    if (line.trim().isEmpty()){
                        crlf = true;
                    }
                }

                Header header = new Header(unparsedHeader);
                StatusCode statusCode = Routes.validRequest(header.method, header.path);
                String httpResponse = Response.createResponse(statusCode.getWholeStatus());

                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}