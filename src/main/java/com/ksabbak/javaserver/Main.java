package com.ksabbak.javaserver;
import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int portNumber = 5000;
        Server server = new Server();

        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        while (true){

            try (Socket socket = serverSocket.accept()) {
                String httpResponse = "HTTP/1.1 " + server.statusCode() + "\r\n\r\n";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}