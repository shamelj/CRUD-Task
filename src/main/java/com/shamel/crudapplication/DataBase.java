package com.shamel.crudapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static Connection connection;
    private DataBase(){

    }
    public static Connection getConnection(){
        if(connection==null)
            initializeConnection();
        return connection;

    }
    private static void initializeConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crud_db","root","root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
