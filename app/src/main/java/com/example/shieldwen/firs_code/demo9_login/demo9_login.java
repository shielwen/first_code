package com.example.shieldwen.firs_code.demo9_login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo2.demo2_main;

public class demo9_login extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1,editText2;
    private Button button1,button2;
    private TextView textView1,textView2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo9_login);
        findView();
    }
    public void findView(){
        editText1=findViewById(R.id.demo9_login_edt1);
        editText2=findViewById(R.id.demo9_login_edt2);
        button1=findViewById(R.id.demo9_login_btn1);
        button2=findViewById(R.id.demo9_login_btn2);
        textView1=findViewById(R.id.demo9_login_text1);
        textView2=findViewById(R.id.demo9_login_text2);
        button1.setOnClickListener(this); button2.setOnClickListener(this);
        textView1.setOnClickListener(this);textView2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demo9_login_btn1:
                intent = new Intent(demo9_login.this,demo9_register.class);
                startActivity(intent);
                break;
            case R.id.demo9_login_btn2:
                String user = editText1.getText().toString();
                String password = editText2.getText().toString();
                if(user.equals("")||password.equals("")){
                    Toast.makeText(demo9_login.this,"账号/密码 不能为空",Toast.LENGTH_SHORT).show();
                } else if(password.equals(getSharedPreferencesString(user+"","password"))){
                         intent = new Intent(demo9_login.this,demo2_main.class);
                         startActivity(intent);
                         putSharedPreferencesString("login","ok","yes");//设置已经登陆
                         putSharedPreferencesString("login","user",user+"");//设置登录用户
                    Toast.makeText(demo9_login.this,"登录成功",Toast.LENGTH_SHORT).show();
                 }else{
                    Toast.makeText(demo9_login.this,"账号/密码错误",Toast.LENGTH_SHORT).show();
                 }
                break;
            case R.id.demo9_login_text1:
                Toast.makeText(demo9_login.this,"暂时不支持",Toast.LENGTH_SHORT).show();
                break;
            case R.id.demo9_login_text2:
                putSharedPreferencesString("login","user","游客");
                intent = new Intent(demo9_login.this,demo2_main.class);
                startActivity(intent);
                finish();
                break;
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
