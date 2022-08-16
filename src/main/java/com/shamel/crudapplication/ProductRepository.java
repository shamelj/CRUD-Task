package com.shamel.crudapplication;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);

    Product retrieveProduct(int id);

    List<Product> retrieveAllProducts() throws SQLException;

    void deleteProduct(int id);

    void updateProduct(Product product);
}
