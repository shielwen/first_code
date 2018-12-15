package com.example.shieldwen.firs_code.demo5_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shieldwen.firs_code.Mysql_jdbc.User;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.MyDatabaseHelper;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Userdao;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.start_useTable;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Myuser;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class demo5_sqlite extends AppCompatActivity implements OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private TextView textView;
    private Intent intent;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_sqlite);
        MyDatabaseHelper myDatabaseHelper=start_useTable.create(this);
        findViews();
    }
    private void findViews() {
        button1 = findViewById(R.id.demo5_sqlite_button1);
        button2 = findViewById(R.id.demo5_sqlite_button2);
        button3 = findViewById(R.id.demo5_sqlite_button3);
        button4 = findViewById(R.id.demo5_sqlite_button4);
        button5 = findViewById(R.id.demo5_sqlite_button5);
        button6 = findViewById(R.id.demo5_sqlite_button6);
        button7 = findViewById(R.id.demo5_sqlite_button7);
        button8 = findViewById(R.id.demo5_sqlite_button8);
        button9 = findViewById(R.id.demo5_sqlite_button9);
        button10 = findViewById(R.id.demo5_sqlite_button10);
        textView = findViewById(R.id.demo5_sqlite_text1);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //判断所触发的被监听控件，并执行命令
        switch (v.getId()){
            case R.id.demo5_sqlite_button1:
                intent = new Intent(demo5_sqlite.this,demo5_User.class);
                startActivity(intent);

                break;
            case R.id.demo5_sqlite_button2:break;
            case R.id.demo5_sqlite_button3:break;
            case R.id.demo5_sqlite_button4:break;
            case R.id.demo5_sqlite_button5:break;
            case R.id.demo5_sqlite_button6:break;
            case R.id.demo5_sqlite_button7:break;
            case R.id.demo5_sqlite_button8:break;
            case R.id.demo5_sqlite_button9:break;
            case R.id.demo5_sqlite_button10:break;
                default: break;
        }
    }
}
