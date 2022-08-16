package com.shamel.crudapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDataBaseRepository implements ProductRepository {
    private static final Connection con = DataBaseConnection.getConnection();

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Product retrieveProduct(int id) {
        return null;
    }

    @Override
    public List<Product> retrieveAllProducts() throws SQLException {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery("select * from product");
            List<Product> products = new ArrayList<>();
            while(result.next()){
                int id = result.getInt("id");
                float price = result.getFloat("price");
                String name = result.getString("name");
                Product product = new Product(id,price,name);
                products.add(product);
            }
            return products;


    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void updateProduct(Product product) {

    }
}
