package com.example.shieldwen.firs_code.demo5_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Userdao;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Myuser;

import java.util.ArrayList;

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
    private  ArrayList<String> Userlist = new ArrayList<String>();


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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demo5_user_button1:
                Myuser myuser1 = new Myuser();
                myuser1.setId(Integer.parseInt(editText1.getText().toString()));
                myuser1.setUsername(editText2.getText().toString());
                myuser1.setPassword(editText3.getText().toString());
                Userdao.insert(myuser1);
                break;
            case R.id.demo5_user_button2:
                Myuser myuser2 = new Myuser();
                myuser2.setUsername(editText5.getText().toString());
                Userdao.delete(myuser2);
                break;
            case R.id.demo5_user_button3:
                Myuser myuser3 = new Myuser();
                myuser3.setUsername(editText7.getText().toString());
                myuser3.setPassword(editText8.getText().toString());
                Userdao.updata(myuser3);
                break;
            case R.id.demo5_user_button4:
                Userdao.query(Userlist);
                StringBuffer text = new StringBuffer();
                for(int i=0;i<Userlist.size();i++){
                    String text1 = Userlist.get(i);
                    text.append((i+1)/2+"---"+text1);
                    text.append("\n");
                    textview10.setText(text);
                }

                break;

        }

    }

}
