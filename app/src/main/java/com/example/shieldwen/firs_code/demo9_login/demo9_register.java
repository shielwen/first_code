package com.example.shieldwen.firs_code.demo9_login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;

public class demo9_register extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo9_register);
        findView();
    }
    public void findView(){
        editText1=findViewById(R.id.demo9_register_edt1);
        editText2=findViewById(R.id.demo9_register_edt2);
        editText3=findViewById(R.id.demo9_register_edt3);
        editText4=findViewById(R.id.demo9_register_edt4);
        textView1=findViewById(R.id.demo9_register_btn1);
        textView2=findViewById(R.id.demo9_register_btn2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=editText1.getText().toString();
                String b=editText2.getText().toString();
                String c=editText3.getText().toString();
                String d=editText4.getText().toString();
                if(a.equals("")||c.equals("")||b.equals("")||d.equals("")){
                    Toast.makeText(demo9_register.this, "不能有空栏位", Toast.LENGTH_SHORT).show();
                }else {
                    putSharedPreferencesString(a+"","username",a+"");
                    putSharedPreferencesString(a+"", "password",b+"");
                    putSharedPreferencesString(a+"", "lovemenu",c+"");
                    putSharedPreferencesString(a+"","signature",d+"");
                    Intent intent = new Intent(demo9_register.this, demo9_login.class);
                    startActivity(intent);
                    Toast.makeText(demo9_register.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


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
