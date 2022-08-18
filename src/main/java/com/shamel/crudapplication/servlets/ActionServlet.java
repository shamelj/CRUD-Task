package com.shamel.crudapplication.servlets;

import java.io.*;

import com.shamel.crudapplication.handlers.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ActionServlet", value = "*.do")
public class ActionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String viewUrl = "";
        RouteHandler handler = getRouteHandler(request);
        viewUrl = handler.execute(request);
        getServletContext().getRequestDispatcher(viewUrl).forward(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }
    private RouteHandler getRouteHandler(HttpServletRequest request) {
        RouteHandler handler;
        String url = request.getRequestURI();
        if (url.contains("/DeleteProduct"))
            handler = new DeleteProductHandler();
        else if (url.contains("/AddProduct"))
            handler = new AddProductHandler();
        else if (url.contains("/Products"))
            handler = new RetreiveProductsHandler();
        else if (url.contains("/UpdateProduct"))
            handler = new UpdateProductHandler();
        else
            handler = new ErrorHandler();
        return handler;
    }

    public void destroy() {
    }
}