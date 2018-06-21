package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.router.Router;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        int portNumber = 5000;
        Router router = new Router();

        Server server = new Server();

        server.run(portNumber, router);
    }

}