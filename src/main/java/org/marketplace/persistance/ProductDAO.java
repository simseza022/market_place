package org.marketplace.persistance;

import io.javalin.http.Context;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO extends DataAccess{

    public ProductDAO(){
        super();
    }

    public ArrayList<ProductDO> getAllProducts(){
        ArrayList<ProductDO> products = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory");){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ProductDO productDO = new ProductDO(
                        resultSet.getInt("id"),
                        resultSet.getInt("p_type"),
                        resultSet.getInt("p_size"),
                        resultSet.getInt("p_color"),
                        resultSet.getString("p_description"),
                        resultSet.getString("p_image")
                );
                products.add(productDO);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static int addProduct(int p_type, int p_size, int p_color, String p_description, String p_image){
        try(PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Inventory(p_type, p_size, p_color, p_description, p_image) VALUES (?, ?, ?, ?, ?)");){
            preparedStatement.setInt(1, p_type);
            preparedStatement.setInt(2, p_size);
            preparedStatement.setInt(3, p_color);
            preparedStatement.setString(4, p_description);
            preparedStatement.setString(5, p_image);
            int rowCount = preparedStatement.executeUpdate();
            System.out.println(rowCount);
            return rowCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ProductDO getProduct(int p_id){
        try(PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Inventory WHERE id = ?");){
            preparedStatement.setInt(1, p_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new ProductDO(
                    resultSet.getInt("id"),
                    resultSet.getInt("p_type"),
                    resultSet.getInt("p_size"),
                    resultSet.getInt("p_color"),
                    resultSet.getString("p_description"),
                    resultSet.getString("p_image")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
