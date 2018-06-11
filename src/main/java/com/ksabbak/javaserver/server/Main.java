package com.ksabbak.javaserver.server;
import com.ksabbak.javaserver.router.Router;

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

                String unparsedHeader = "";
                String line;
                Boolean blankLine = false;

                while(!blankLine && ((line = in.readLine()) != null)){
                    unparsedHeader += line + "\n";
                    if (line.trim().isEmpty()){
                        blankLine = true;
                    }
                }

                RequestParser requestParser = new RequestParser(unparsedHeader);

                List<Integer> unparsedBody = new ArrayList<Integer>();
                Integer character;
                int length = 0;

                while((length < requestParser.getContentLength())  && ((character = in.read())!= -1)) {
                    unparsedBody.add(character);
                    length++;
                }

                requestParser.addBody(unparsedBody);
                RequestData requestData = requestParser.parse();


                Response httpResponse = Router.respond(requestData);
                String formattedResponse = httpResponse.formattedResponse();

                socket.getOutputStream().write(formattedResponse.getBytes("UTF-8"));
            }
        }
    }
}
