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

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String unparsedHeader = "";
                String line;
                Boolean crlf = false;

                while(!crlf && ((line = in.readLine()) != null)){
                    unparsedHeader += line;
                    System.out.println(line);
                    if (line.trim().isEmpty()){
                        crlf = true;
                    }
                }

                Header header = new Header(unparsedHeader);
                StatusCode statusCode = Routes.validRequest(header.method, header.path);

                System.out.println(statusCode.getWholeStatus());


                String httpResponse = "HTTP/1.1 " + statusCode.getWholeStatus() + "\r\n\r\n";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}