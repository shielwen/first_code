package com.example.shieldwen.firs_code.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDBConnection {
    public static Connection connectDB(String DBname,String id,String p)
    {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e) {}
        String uri="jdbc:mysql://localhost:3306/"+DBname+"?useSSL=true&characterEncoding=utf-8";
        String user=id;
        String password=p;
        try {
            con = DriverManager.getConnection(uri,user,password);
        }
        catch(SQLException e) {
        }
        return con;
    }
}
