package com.shamel.crudapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataBaseRepository implements ProductRepository {
    private static final Connection con = DataBaseConnection.getConnection();

    @Override
    public void addProduct(Product product) throws SQLException {
        String query = "Insert into product(id,name,price) values (?,?,?);";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,product.getId());
        ps.setString(2,product.getName());
        ps.setFloat(3,product.getPrice());
        int effectedRows = ps.executeUpdate();
        System.out.println(effectedRows);

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
    public void deleteProduct(int id) throws SQLException {
        String query
                = "delete from product where id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String query = "update product set name = ?, price = ? where id = ? ;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,product.getName());
        ps.setFloat(2,product.getPrice());
        ps.setInt(3,product.getId());
        int effectedRows = ps.executeUpdate();
        if (effectedRows == 0)
            throw  new SQLException("This user doesn't exist.");
        System.out.println(effectedRows);
    }
}
