package com.example.shieldwen.firs_code;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shieldwen.firs_code.demo1.demo1_main;
import com.example.shieldwen.firs_code.demo2.demo2_main;
import com.example.shieldwen.firs_code.demo3.demo3_main;
import com.example.shieldwen.firs_code.demo4.demo4_zhiwen;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.MyDatabaseHelper;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.start_useTable;
import com.example.shieldwen.firs_code.demo5_sqlite.demo5_sqlite;
import com.example.shieldwen.firs_code.demo8_tomacat_jsp.demo8_tomacat;
import com.example.shieldwen.firs_code.demo9_login.demo9_login;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button9;
    Intent intent;

    private static final String SWOR="SWORD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabaseHelper myDatabaseHelper=start_useTable.create(this);
        ActionBar actionBar =getSupportActionBar();//隐藏标题
        if(actionBar !=null){
            actionBar.hide();
        }
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6=(Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7=(Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button9=(Button)findViewById(R.id.button9);
        button9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                intent = new Intent(MainActivity.this,demo1_main.class);
                startActivity(intent);
                Log.i(SWOR,"123");
                     break;
            case R.id.button2:
                intent = new Intent(MainActivity.this,demo2_main.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this,demo3_main.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(MainActivity.this,demo4_zhiwen.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(MainActivity.this,demo5_sqlite.class);
                startActivity(intent);
                break;
            case R.id.button7:
                intent = new Intent(MainActivity.this,demo8_tomacat.class);
                startActivity(intent);
                break;
            case R.id.button9:
                intent = new Intent(MainActivity.this,demo9_login.class);
                startActivity(intent);
                break;
                     default:
                    break;
        }
    }
}
