package com.hsf301.javafx.lab2_hsf301;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databseLink;
    public Connection getDatabaseConnection() {
        String databaseURL = "jdbc:sqlserver://Localhost:1433;databaseName=lab2_javafx;encrypt=false;";
        String user = "sa";
        String password = "sa";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            databseLink = DriverManager.getConnection(databaseURL, user, password);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return databseLink;
    }
}
