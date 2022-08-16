package com.shamel.crudapplication;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);

    Product retrieveProduct(int id) throws SQLException;

    List<Product> retrieveAllProducts() throws SQLException;

    void deleteProduct(int id) throws SQLException;

    void updateProduct(Product product) throws SQLException;
}
