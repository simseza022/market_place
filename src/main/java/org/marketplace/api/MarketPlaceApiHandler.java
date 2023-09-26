package org.marketplace.api;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.marketplace.persistance.ProductDAO;
import org.marketplace.persistance.ProductDO;

import java.sql.*;
import java.util.ArrayList;

public class MarketPlaceApiHandler {

    public static void getAllProducts(Context context){
        ProductDAO productDAO = new ProductDAO();
        ArrayList<ProductDO> products =  productDAO.getAllProducts();
        context.status(HttpStatus.OK);
        context.json(products);
    }


    public static void getProduct(Context context) {
        ProductDAO productDAO = new ProductDAO();
        Integer id = context.pathParamAsClass("id", Integer.class).get();
        ProductDO productDO = productDAO.getProduct(id);
        context.status(HttpStatus.OK);
        context.json(productDO);
    }
}
