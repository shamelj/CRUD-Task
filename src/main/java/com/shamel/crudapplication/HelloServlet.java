package com.shamel.crudapplication;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection con = DataBase.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs=stm.executeQuery("select * from product");
            while(rs.next())
                out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            //con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Hello
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}