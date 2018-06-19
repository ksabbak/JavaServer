package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.app.Routable;
import com.ksabbak.javaserver.app.Routes;
import com.ksabbak.javaserver.router.Router;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public void run(int portNumber, Router router) throws IOException {
        Routable routable = new Routes(router);
        int threadPoolSize = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable requestHandler = new RequestHandler(socket, router);
            executorService.execute(requestHandler);
        }
    }
}