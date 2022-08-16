package com.shamel.crudapplication.servlets;

import com.shamel.crudapplication.Product;
import com.shamel.crudapplication.ProductDataBaseRepository;
import com.shamel.crudapplication.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", value = "/AddProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "/add.jsp", message = "";
        ProductRepository repository = new ProductDataBaseRepository();
        Product product = createProduct(request);
        try {
            repository.addProduct(product);
            message = "Added Successfully";
        } catch (SQLException e) {
            message = "User Already exists";
        }
        request.setAttribute("message",message);
        getServletContext().getRequestDispatcher(url).forward(request,response);


    }

    private Product createProduct(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        Product product = new Product(id,price,name);
        return product;
    }

}
