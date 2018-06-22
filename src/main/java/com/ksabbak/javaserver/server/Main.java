package com.ksabbak.javaserver.server;

import com.ksabbak.javaserver.router.Router;
import com.ksabbak.javaserver.storage.Persistable;
import com.ksabbak.javaserver.storage.Store;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        int portNumber = 5000;

        Persistable storage = new Store();
        Router router = new Router(storage);

        Server server = new Server();

        server.run(portNumber, router);
    }

}