package org.marketplace.api;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketPlaceAPITest {
    static MarketPlaceAPI server;
    @BeforeAll
    public static void startServer() {
        server = new MarketPlaceAPI();
        server.start(6000);
        System.out.println("Started");
    }

    @AfterAll
    public static void stopServer() {
        server.stop();
    }
    @Test
    @DisplayName("GET /products")
    public void getAllProducts() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:6000/products").asJson();
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaders().getFirst("Content-Type"));
        System.out.println(response.getBody());

//        Map <String,Object> res = convRespnseToMap(response.getBody().getArray().get(0).toString());
//        assertEquals("testSaveWO", res.get("name"));
    }

    @Test
    @DisplayName("GET /product/{id}")
    public void getProduct() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:6000/product/2").asJson();
        assertEquals(200, response.getStatus());
        assertEquals("application/json", response.getHeaders().getFirst("Content-Type"));
        System.out.println(response.getBody());
    }


}