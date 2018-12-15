package com.example.shieldwen.firs_code.demo5_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Myuser;

public class demo5_User extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button4;
    private EditText editText5;
    private Button button6;
    private EditText editText7;
    private EditText editText8;
    private Button button9;
    private TextView textview10;
    private Button button11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5__user);
    }
    public  void  findview(){
        editText1 = findViewById(R.id.demo5_user_button1);
        editText2 = findViewById(R.id.demo5_user_button2);
        editText3 = findViewById(R.id.demo5_user_button3);
        button4 =(Button)findViewById(R.id.demo5_user_button4);
        editText5 = findViewById(R.id.demo5_user_button5);
        button6 = (Button)findViewById(R.id.demo5_user_button6);
        editText7 = findViewById(R.id.demo5_user_button7);
        editText8 = findViewById(R.id.demo5_user_button8);
        button9 = (Button)findViewById(R.id.demo5_user_button9);
        textview10 = (TextView)findViewById(R.id.demo5_user_button10);
        button9 = (Button)findViewById(R.id.demo5_user_button11);
    }
               /*  Myuser myuser =new Myuser();
                myuser.setUsername("123465");
                myuser.setPassword("123456");
                Userdao.insert(myuser);
                Userdao.query(list);
    StringBuffer text = new StringBuffer();
                for(int i=0;i<list.size();i++){
        String text1 = list.get(i);

        text.append(i+"---"+text1);
        text.append("\n");
    }
                textView.setText(text);*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demo5_user_button1:
                Myuser myuser = new Myuser();
                myuser.setId(1);
                break;
            case R.id.demo5_user_button2:
                break;
            case R.id.demo5_user_button3:
                break;
            case R.id.demo5_user_button4:
                break;

        }

    }

}
