package com.example.shieldwen.firs_code.demo7_otheractivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;

public class demo7_main_setting extends AppCompatActivity implements View.OnClickListener {
    EditText editText1,editText2,editText3; //三个输入框
    TextView textView1,textView2;//待定和确定
    TextView textView3;//用户名
    Intent intent;//传值
    Intent getintent;//得值

    String user;//用户名
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_main_setting);
        findView();

        user = getSharedPreferencesString("login","user");
        textView3.setText(getSharedPreferencesString(user+"","username"));
        editText1.setText(getSharedPreferencesString(user+"","lovemenu"));
        editText2.setText(getSharedPreferencesString(user+"","signature"));

    }
    public void findView(){
        editText1=findViewById(R.id.demo7_set_edt3);
        editText2=findViewById(R.id.demo7_set_edt4);
        editText3=findViewById(R.id.demo7_set_edt5);
        textView1=findViewById(R.id.demo7_main_setting_back);
        textView2=findViewById(R.id.demo7_main_setting_ok);
        textView3 =findViewById(R.id.demo7_set_text2);
       textView1.setOnClickListener(this);
       textView2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.demo7_main_setting_back:finish();break;
            case R.id.demo7_main_setting_ok:
                putSharedPreferencesString(user+"","lovemenu",editText1.getText().toString());
                putSharedPreferencesString(user+"","signature",editText2.getText().toString());
                intent = new Intent(demo7_main_setting.this,demo7_mainActivity.class);
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
