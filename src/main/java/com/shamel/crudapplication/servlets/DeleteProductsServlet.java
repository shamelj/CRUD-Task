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
import java.util.List;

@WebServlet(name = "DeleteServlet", value = "/DeleteProduct")
public class DeleteProductsServlet extends HttpServlet {

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        getServletContext().getRequestDispatcher(url).forward(request,response);


    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doDelete(request,response);
    }
}
