import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import db.DataBase;

import java.io.IOException;
import java.io.OutputStream;

public class ServerHandler implements HttpHandler {

    Gson gson;
    DataBase dataBase;
    public ServerHandler(Gson gson) {
        dataBase = new DataBase();
        this.gson = gson;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        dataBase.connect();
        String response= gson.toJson(dataBase.getContracts());
        dataBase.disconnect();
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

