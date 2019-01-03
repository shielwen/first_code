package com.example.shieldwen.firs_code.demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;

public class demo2_fragment3_fabu extends  AppCompatActivity{
    TextView textView1;
    TextView textView2;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2_fragment3_fabu);
        findview();

    }
    public void findview(){
        textView1=findViewById(R.id.button_back);
        textView2 = findViewById(R.id.button_fabu);

        editText1= findViewById(R.id.li_edt1);
        editText2= findViewById(R.id.li_edt2);
        editText3= findViewById(R.id.li_edt3);
        editText4= findViewById(R.id.li_edt4);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(demo2_fragment3_fabu.this,demo2_main.class);
                StringBuffer str = new StringBuffer();
                str.append("菜名： "+editText1.getText().toString()+"\n简介："+editText2.getText().toString()+"\n配料："+editText3.getText().toString()+"\n做法："+editText4.getText().toString()+"\n");
                String str2 =new String();
                str2 =str.toString();
                intent.putExtra("shequ",""+str2);
                startActivity(intent);
                finish();
            }
        });
    }
}