package com.shamel.crudapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductsServlet", value = "/Products")

public class RetrieveProductsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        getServletContext().getRequestDispatcher(url).forward(request,response);


    }
}
