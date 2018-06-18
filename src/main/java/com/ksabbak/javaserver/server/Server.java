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
    Boolean listening = false;
    public void run(int portNumber, Router router) throws IOException {
        Routable routable = new Routes(router);
        int totalThreads = 10;
//        int i = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);
        ServerSocket serverSocket =
                new ServerSocket(portNumber);
        while (true) {
            Socket socket = serverSocket.accept();
//                newThread(socket, router, executorService);
                Runnable requestHandler = new RequestHandler(socket, router, this);
                Thread thread = new Thread(requestHandler);
                thread.start();
//                executorService.execute(requestHandler);

//                RequestHandler requestHandler = new RequestHandler(socket, router, this);
//            Runnable requestHandler = new RequestHandler(serverSocket, router, this);
//            executorService.execute(requestHandler);



        }
    }

//    public void newThread(ServerSocket serverSocket, Router router, ExecutorService executorService){
//        if (!listening) {
//            Runnable requestHandler = new RequestHandler(serverSocket, router, this);
//            executorService.execute(requestHandler);
//            listening = true;
//        }
////        requestHandler.run();
//    }

//    public void turnListeningOff(){
//        listening = false;
//    }

}

//public class TestThreadPool {
//     public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
//        for (int i = 0; i < 10; i++) {
//            Runnable worker = new WorkerThread("" + i);
//            executor.execute(worker);//calling execute method of ExecutorService
//          }
//        executor.shutdown();
//        while (!executor.isTerminated()) {   }
//
//        System.out.println("Finished all threads");
//    }
// }