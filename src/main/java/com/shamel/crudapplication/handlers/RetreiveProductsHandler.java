package com.shamel.crudapplication.handlers;

import com.shamel.crudapplication.Product;
import com.shamel.crudapplication.ProductDataBaseRepository;
import com.shamel.crudapplication.ProductRepository;
import com.shamel.crudapplication.handlers.RouteHandler;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;

public class RetreiveProductsHandler implements RouteHandler {
    @Override
    public String execute(HttpServletRequest request) {
        String url = "/products.jsp", message = "";
        ProductRepository repository = new ProductDataBaseRepository();
        List<Product> products = null;
        try {
            products = repository.retrieveAllProducts();
        } catch (SQLException e) {
            message = e.getMessage();
        }
        request.setAttribute("message",message);
        request.setAttribute("products",products);
        return url;
    }
}
