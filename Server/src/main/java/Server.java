import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    ThreadPoolExecutor threadPoolExecutor;
    HttpServer server;
    final static int PORT = 8189;
    Gson gson;

    public Server() {
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        gson = new GsonBuilder().create();
        initServer();
    }

    private void initServer() {
        try {
            server = HttpServer.create(new InetSocketAddress("localhost", PORT), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.createContext("/contracts", new ServerHandler(gson));
        server.setExecutor(threadPoolExecutor);
        server.start();
        System.out.println("Server started on port " + PORT);;
    }
}
