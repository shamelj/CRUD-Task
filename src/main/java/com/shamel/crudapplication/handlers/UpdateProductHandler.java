package com.shamel.crudapplication.handlers;

import com.shamel.crudapplication.Product;
import com.shamel.crudapplication.ProductDataBaseRepository;
import com.shamel.crudapplication.ProductRepository;
import com.shamel.crudapplication.handlers.RouteHandler;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;

public class UpdateProductHandler implements RouteHandler {
    @Override
    public String execute(HttpServletRequest request) {
        String url = "/update.jsp", message = "";
        ProductRepository repository = new ProductDataBaseRepository();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = createProduct(request);
        try {
            repository.updateProduct(product);
            message = "Updated Successfully";
        } catch (SQLException e) {
            message = e.getMessage();
        }
        request.setAttribute("message",message);
        return url;
    }
    private Product createProduct(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        Product product = new Product(id,price,name);
        return product;
    }
}
