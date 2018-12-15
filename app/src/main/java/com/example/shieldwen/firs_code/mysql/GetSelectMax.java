package com.example.shieldwen.firs_code.mysql;

import java.sql.*;
public class GetSelectMax {
    public static int getSelectMax(String statement)
    {
        int max=-1;
        ResultSet rs=null;
        Statement sql;
        Connection con=null;
        try {
            con=GetDBConnection.connectDB("caidao","root","");
            sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=sql.executeQuery(statement );
            rs.last();
            max=rs.getRow();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return max;
    }
}
