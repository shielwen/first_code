package com.example.shieldwen.firs_code.demo5_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.MenuDao;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Menu_model;

import java.util.ArrayList;

public class demo5_Menu extends AppCompatActivity implements View.OnClickListener{
    //增  7个 =  1个button
    private EditText editTextzen1;
    private EditText editTextzen2;
    private EditText editTextzen3;
    private Button buttonzen4;

    private EditText editTextshan1;
    private Button buttonshan2;

    private EditText editTextgai1;
    private Button buttongai3;
    private EditText editTextgai2;

    private EditText editTextcha1;
    private Button buttoncha2;
    private TextView textViewcha3;


    public ArrayList<String> Menulist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5__menu);
        findview();
    }
    public void findview(){
        editTextzen1 = findViewById(R.id.demo5_menu_zen1);
        editTextzen2 = findViewById(R.id.demo5_menu_zen2);
        editTextzen3 = findViewById(R.id.demo5_menu_zen3);
        buttonzen4 =findViewById(R.id.demo5_menu_zen4);

        editTextshan1=findViewById(R.id.demo5_menu_shan1);
        buttonshan2=findViewById(R.id.demo5_menu_shan2);

        editTextgai1=findViewById(R.id.demo5_menu_gai1);
        buttongai3=findViewById(R.id.demo5_menu_gai3);
        editTextgai2=findViewById(R.id.demo5_menu_gai2);

        editTextcha1=findViewById(R.id.demo5_menu_cha1);
        buttoncha2 =findViewById(R.id.demo5_menu_cha2);
        textViewcha3 =findViewById(R.id.demo5_menu_cha3);

        buttonzen4.setOnClickListener(this);
        buttonshan2.setOnClickListener(this);
        buttongai3.setOnClickListener(this);
        buttoncha2.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demo5_menu_zen4:
                Menu_model m1 = new Menu_model();
                m1.setId(Integer.parseInt(editTextzen1.getText().toString()));
                m1.setMenu_name(editTextzen2.getText().toString());
                m1.setPeiliao(editTextzen3.getText().toString());
                MenuDao.insert(m1);
                editTextzen1.setText("");
                break;
            case R.id.demo5_menu_shan2:
                Menu_model m2 = new Menu_model();
                m2.setMenu_name(editTextshan1.getText().toString());
                MenuDao.delete(m2);
                break;
            case R.id.demo5_menu_gai3:
                Menu_model m3 = new Menu_model();
                m3.setMenu_name(editTextgai1.getText().toString());
                m3.setPeiliao(editTextgai2.getText().toString());
                MenuDao.updata(m3);
                break;
            case R.id.demo5_menu_cha2:
                String s = editTextcha1.getText().toString();
                StringBuffer text = new StringBuffer();
                if(s.equals("all")){
                    Toast.makeText(demo5_Menu.this,"s.equals(all)",Toast.LENGTH_SHORT).show();
                    MenuDao.query(Menulist);
                    for(int i=0;i<Menulist.size();i++){
                        String text1 = Menulist.get(i);
                        if(i%2==0){
                            text.append("菜名:\n"+"---"+text1);  text.append("\n");
                        }else {
                            text.append("配料:\n"+"---"+text1);  text.append("\n");
                        }
                    }
                    textViewcha3.setText(text+"123");
                }
                else {
                    Menu_model m =new Menu_model();
                    m.setMenu_name(s);
                    try{
                        MenuDao.query1(m);
                        Toast.makeText(demo5_Menu.this,"132"+s,Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                    }
                    StringBuffer text1= new StringBuffer();
                    text1.append(m.getMenu_name()+"\n"+m.getPeiliao()+"\n123456");
                    textViewcha3.setText(text1);
                }
                break;
        }
    }
}
