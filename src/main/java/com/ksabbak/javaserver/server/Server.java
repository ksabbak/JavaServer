package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.app.Routable;
import com.ksabbak.javaserver.app.Routes;
import com.ksabbak.javaserver.router.Router;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void run(int portNumber, Router router) throws IOException {
        Routable routable = new Routes(router);
        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable requestHandler = new RequestHandler(socket, router);
            Thread thread = new Thread(requestHandler);
            thread.start();
        }
    }
}