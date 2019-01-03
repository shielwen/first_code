package com.example.shieldwen.firs_code.demo3;

import com.example.shieldwen.firs_code.demo2.demo2_main;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.MyDatabaseHelper;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.start_useTable;
import com.example.shieldwen.firs_code.demo9_login.demo9_login;
import com.tencent.tauth.Tencent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

import android.support.v7.app.AppCompatActivity;

import com.example.shieldwen.firs_code.R;

public class demo3_main extends AppCompatActivity implements OnClickListener {
    demo3_main mActivity;
    private Tencent mTencent;// 新建Tencent实例用于调用分享方法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3_main);
        MyDatabaseHelper myDatabaseHelper=start_useTable.create(this);
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getSharedPreferencesString("login","ok").equals("yes")){
                    Intent intent = new Intent(demo3_main.this,demo2_main.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(demo3_main.this,demo9_login.class);
                    startActivity(intent);
                }
                finish();
            }
        },2000);
    }



    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
    public void putSharedPreferencesString(String filename,String id,String con){
        SharedPreferences.Editor editor = getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putString(id,con);
        editor.apply();
    }
    public String getSharedPreferencesString(String filename,String id){
        SharedPreferences preferences = getSharedPreferences(filename,MODE_PRIVATE);
        String con = preferences.getString(id,"");
        return con;
    }
}