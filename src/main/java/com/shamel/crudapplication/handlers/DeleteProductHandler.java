package com.shamel.crudapplication.handlers;

import com.shamel.crudapplication.ProductDataBaseRepository;
import com.shamel.crudapplication.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;

public class DeleteProductHandler implements RouteHandler {
    @Override
    public String execute(HttpServletRequest request) {
        String url = "/delete.jsp", message = "";
        ProductRepository repository = new ProductDataBaseRepository();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            repository.deleteProduct(id);
            message = "Deleted Successfully";
        } catch (SQLException e) {
            message = e.getMessage();
        }
        request.setAttribute("message",message);
        return url;
    }
}
