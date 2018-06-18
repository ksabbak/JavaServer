package com.ksabbak.javaserver.server;
import com.ksabbak.javaserver.app.Routable;
import com.ksabbak.javaserver.app.Routes;
import com.ksabbak.javaserver.router.Router;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        int portNumber = 5000;
        Router router = new Router();

        Server server = new Server();

        server.run(portNumber, router);
    }

}