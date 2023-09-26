package org.marketplace.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DataAccess {
    public static String DISK_DB_URL = "jdbc:sqlite:";
    protected static Connection connection = null;

    public DataAccess(){
        connectToDb();
    }

    public static void connectToDb(){
        try {
            connection = DriverManager.getConnection(DISK_DB_URL+"src/main/java/org/marketplace/marketDB");
            PreparedStatement preparedStatement = connection.prepareStatement("PRAGMA foreign_keys = ON");
            preparedStatement.execute();
            //Query objects
            System.out.println( "Connected to database." );
        }catch( SQLException e ){
            System.out.println( e.getMessage() );
            e.printStackTrace();
        }
    }

}
