package com.example.shieldwen.firs_code.demo5_sqlite.dao;


import android.content.Context;

public class start_useTable {
    public static  MyDatabaseHelper myDatabaseHelper;
    public  static MyDatabaseHelper  create(Context context){
        myDatabaseHelper = new MyDatabaseHelper
                (context,"shieldwen.db",null,1);
        myDatabaseHelper.getWritableDatabase();
        return  myDatabaseHelper;
    }
}
