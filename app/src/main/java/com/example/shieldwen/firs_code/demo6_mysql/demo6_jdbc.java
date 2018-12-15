package com.example.shieldwen.firs_code.demo6_mysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.Mysql_jdbc.DBService;
import com.example.shieldwen.firs_code.Mysql_jdbc.User;
import com.example.shieldwen.firs_code.R;

import java.util.ArrayList;
import java.util.List;

public class demo6_jdbc extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView textView;
    String[][] result;
    String sss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6_jdbc);
        buildid();


    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.demo6_button1:
                DBService a = DBService.getDbService();
                List<User> list1=new ArrayList<User>();
                       list1= a.getUserData();
                       User user = new User();
                       user.setId("123");
                       list1.add(user);
                       int i =list1.size();
                       String s ="123"+i;
                       textView.setText(s);
                break;
            case R.id.demo6_button2:Toast.makeText(demo6_jdbc.this,"123",Toast.LENGTH_SHORT).show();
                break;
            case R.id.demo6_button3:
                break;
            case R.id.demo6_button4:
                break;
            default:
                break;
        }
    }
    public void buildid(){
        button1 = (Button)findViewById(R.id.demo6_button1);
        button2 = (Button)findViewById(R.id.demo6_button2);
        button3 = (Button)findViewById(R.id.demo6_button3);
        button4 = (Button)findViewById(R.id.demo6_button4);
        textView =(TextView)findViewById(R.id.demo6_button5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        textView.setOnClickListener(this);
    }
}
