package com.example.shieldwen.firs_code.demo5_sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shieldwen.firs_code.demo5_sqlite.model.Myuser;

import java.util.ArrayList;

public class Userdao {
        public  static MyDatabaseHelper myDatabaseHelper =start_useTable.myDatabaseHelper;
        public static   SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        public static   ContentValues contentValues = new ContentValues();
        public static void insert(Myuser myuser){
            contentValues.put("id",myuser.getId());
            contentValues.put("username",myuser.getUsername());
            contentValues.put("password",myuser.getPassword());
            sqLiteDatabase.insert("User","username",contentValues);
            contentValues.clear();
        }
    public static void updata(Myuser myuser) {
        contentValues.put("password",myuser.getPassword());
        sqLiteDatabase.update("User",contentValues,"username=?",new String[]{myuser.getUsername()});

    }
    public static void delete(Myuser myuser) {
            sqLiteDatabase.delete("User","username=?",new String[]{myuser.getUsername()});
    }

    public static void query(ArrayList list) {
        Cursor cursor = sqLiteDatabase.query("User",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                list.add(username);
                list.add(password);
            }while (cursor.moveToNext());
        }
        cursor.close();
        }
}
