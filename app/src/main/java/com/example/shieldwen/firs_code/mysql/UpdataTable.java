package com.example.shieldwen.firs_code.mysql;

import java.sql.*;
public class UpdataTable {
    public static int updataTable(String statement)
    {
        int ok=0;
        Statement sql;
        Connection con=null;
        try {
            con=GetDBConnection.connectDB("caidao","root","");
            sql=con.createStatement();
            ok=sql.executeUpdate(statement);
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return ok;
    }
}