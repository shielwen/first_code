package com.example.shieldwen.firs_code.demo5_sqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
     public static final String CREATE_USER ="create table User("
             + "id integer primary key autoincrement,"
             + "username text,"
             + "password text)";
     private  Context mcontext;
    public static final String CREATE_MENU="create table Menu("
            + "id integer primary key autoincrement," +
            "menu_name text," +
            "peiliao text)";
    public static final String CREATE_MYCOLLECT="create table Mycollect("
            + "id integer primary key autoincrement,"
            + "menu_name text )";
    public static final String CREATE_MYHISTORY="create table Myhistory("
            + "id integer primary key autoincrement,"
            + "menu_name text  )";




     public MyDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
         super(context,name,factory,version);
         mcontext=context;

     }
     @Override
    public void onCreate(SQLiteDatabase db){
         db.execSQL(CREATE_USER);
         db.execSQL(CREATE_MYCOLLECT);
         db.execSQL(CREATE_MENU);
         db.execSQL(CREATE_MYHISTORY);
         Toast.makeText(mcontext,"12",Toast.LENGTH_SHORT).show();

     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String str = "drop table if exists ";
        db.execSQL(str +"User");
        db.execSQL(str +"Menu");
        db.execSQL(str +"Mycollect");
        db.execSQL(str +"Myhistory");
        onCreate(db);
    }
}