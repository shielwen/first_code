package com.example.shieldwen.firs_code.demo7_otheractivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo2.demo2_main;
import com.example.shieldwen.firs_code.demo9_login.demo9_login;

public class demo7_setting extends AppCompatActivity {
    LinearLayout linearLayout1,linearLayout2,linearLayout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_setting);
        TextView textView=findViewById(R.id.demo7_setting_back);
        linearLayout1=findViewById(R.id.demo7_setting_lin1);
        linearLayout2=findViewById(R.id.demo7_setting_lin2);
        linearLayout3=findViewById(R.id.demo7_setting_lin3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(demo7_setting.this,"暂时不支持",Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(demo7_setting.this,"暂时不支持",Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(demo7_setting.this,"已退出",Toast.LENGTH_SHORT).show();
                putSharedPreferencesString("login","ok","no");
                Intent intent = new Intent(demo7_setting.this,demo9_login.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void putSharedPreferencesString(String filename,String id,String con){
        SharedPreferences.Editor editor = getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putString(id,con);
        editor.apply();
    }
}
