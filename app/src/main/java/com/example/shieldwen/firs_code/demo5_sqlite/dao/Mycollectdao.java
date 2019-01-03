package com.example.shieldwen.firs_code.demo5_sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shieldwen.firs_code.demo5_sqlite.model.Mycollect;

import java.util.ArrayList;

public class Mycollectdao {
    public  static MyDatabaseHelper myDatabaseHelper =start_useTable.myDatabaseHelper;
    public static SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
    public static ContentValues contentValues = new ContentValues();

    public static void  insert(Mycollect m){
        contentValues.put("id",m.getId());
        contentValues.put("menu_name",m.getMenu_name());
        sqLiteDatabase.insert("Mycollect","menu_name",contentValues);
        contentValues.clear();
    }
    public static void  delete(Mycollect m){
        sqLiteDatabase.delete("Mycollect","menu_name=?",new String[]{m.getMenu_name()});
    }
    public static void query(ArrayList list) {
        Cursor cursor = sqLiteDatabase.query("Mycollect",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String username = cursor.getString(cursor.getColumnIndex("menu_name"));
                list.add(username);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}
