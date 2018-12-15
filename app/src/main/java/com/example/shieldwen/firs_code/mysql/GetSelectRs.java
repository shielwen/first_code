package com.example.shieldwen.firs_code.mysql;
import java.sql.*;
public class GetSelectRs {
    public static ResultSet getSelectRs(String statement)
    {
        ResultSet rs=null;
        Statement sql;
        Connection con=null;
        try {
            con=GetDBConnection.connectDB("caidao","root","");
            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=sql.executeQuery(statement );
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return rs;
    }
}
