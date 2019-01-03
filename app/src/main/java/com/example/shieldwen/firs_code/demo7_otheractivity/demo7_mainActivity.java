package com.example.shieldwen.firs_code.demo7_otheractivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;

public class demo7_mainActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    TextView textView_back;
    Intent intent;
    Intent getintent;
    String user;//用户
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_main);
        findView();
            user = getSharedPreferencesString("login","user");
            textView2.setText(getSharedPreferencesString(user+"","username"));
            textView3.setText(getSharedPreferencesString(user+"","lovemenu"));
            textView4.setText(getSharedPreferencesString(user+"","signature"));
    }
    public void findView(){
        textView1=findViewById(R.id.mybutton1);
        textView2=findViewById(R.id.mybutton2);
        textView3=findViewById(R.id.mybutton3);
        textView4=findViewById(R.id.mybutton4);
        textView5=findViewById(R.id.mybutton5);
        textView6=findViewById(R.id.mybutton6);
        textView7=findViewById(R.id.mybutton7);
        textView_back=findViewById(R.id.demo7_main_back);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(user.equals("游客")){
                    Toast.makeText(demo7_mainActivity.this,"作为一个游客\n你没有权力修改资料！",Toast.LENGTH_SHORT).show();
                }
                else {
                    intent = new Intent(demo7_mainActivity.this,demo7_main_setting.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
