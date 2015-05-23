package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    public static Connection getConnection() throws Exception {
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        return con;
    }
}
