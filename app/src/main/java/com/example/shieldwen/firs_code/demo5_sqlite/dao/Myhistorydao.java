package com.example.shieldwen.firs_code.demo5_sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shieldwen.firs_code.demo5_sqlite.model.Mycollect;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Myhistory;

import java.util.ArrayList;

public class Myhistorydao {
    public  static MyDatabaseHelper myDatabaseHelper =start_useTable.myDatabaseHelper;
    public static SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
    public static ContentValues contentValues = new ContentValues();

    public static void  insert(Myhistory m){
        contentValues.put("id",m.getId());
        contentValues.put("menu_name",m.getMenu_name());
        sqLiteDatabase.insert("Myhistory","menu_name",contentValues);
        contentValues.clear();
    }
    public static void  delete(Myhistory  m){
        sqLiteDatabase.delete("Myhistory","menu_name=?",new String[]{m.getMenu_name()});
    }
    public static void  querty(ArrayList str){
        Cursor cursor = sqLiteDatabase.query("Myhistory",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String menu_name= cursor.getString(cursor.getColumnIndex("menu_name"));
                str.add(menu_name);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}

