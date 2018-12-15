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
import com.example.shieldwen.firs_code.demo3_qqshare.demo3_main;
import com.example.shieldwen.firs_code.demo4.demo4_zhiwen;
import com.example.shieldwen.firs_code.demo5_sqlite.demo5_sqlite;
import com.example.shieldwen.firs_code.demo6_mysql.demo6_jdbc;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    Intent intent1;
    Intent intent2;
    Intent intent3;
    Intent intent4;
    Intent intent5;
    Intent intent6;
    private static final String SWOR="SWORD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                intent1 = new Intent(MainActivity.this,demo1_main.class);
                startActivity(intent1);
                Log.i(SWOR,"123");
                     break;
            case R.id.button2:
                intent2 = new Intent(MainActivity.this,demo2_main.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                intent3 = new Intent(MainActivity.this,demo3_main.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                intent4 = new Intent(MainActivity.this,demo4_zhiwen.class);
                startActivity(intent4);
                break;
            case R.id.button5:
                intent5 = new Intent(MainActivity.this,demo5_sqlite.class);
                startActivity(intent5);
                break;
            case R.id.button6:
                intent6 = new Intent(MainActivity.this,demo6_jdbc.class);
                startActivity(intent6);
                break;
                     default:
                    break;
        }
    }
}
