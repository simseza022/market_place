package org.marketplace.api;

import io.javalin.Javalin;

public class MarketPlaceAPI {
    private final Javalin JavalinServer;
    public MarketPlaceAPI() {
        this.JavalinServer = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        });
        this.JavalinServer.get("/products", MarketPlaceApiHandler::getAllProducts);
        this.JavalinServer.get("/product/{id}", MarketPlaceApiHandler::getProduct);
    }


    public static void main(String[] args) {
        MarketPlaceAPI server = new MarketPlaceAPI();
        server.start(5001);
    }

    public void start(int port) {
        this.JavalinServer.start(port);
    }

    public void stop() {
        this.JavalinServer.stop();
    }

}
