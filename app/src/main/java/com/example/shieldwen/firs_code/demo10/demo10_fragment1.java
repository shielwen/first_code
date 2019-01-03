package com.example.shieldwen.firs_code.demo10;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo2.demo2_main;
import com.example.shieldwen.firs_code.demo9_login.demo9_login;

import static android.content.Context.MODE_PRIVATE;

public class demo10_fragment1 extends Fragment {

    EditText editText1;
    EditText editText2;
    String user ;
    String password;
    TextView tv1;
    Intent intent;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        editText1 = getActivity().findViewById(R.id.user);
        editText2 = getActivity().findViewById(R.id.password);
        Button login = getActivity().findViewById(R.id.login);
        tv1 = getActivity().findViewById(R.id.tv1);

        //用账号密码登录时 登录按钮的监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = editText1.getText().toString();
                password = editText2.getText().toString();
                if(user.equals("")||password.equals("")){
                    Toast.makeText(getActivity(),"账号/密码 不能为空",Toast.LENGTH_SHORT).show();
                } else if(password.equals(getSharedPreferencesString(user+"","password"))){
                    intent = new Intent(getActivity(),demo2_main.class);
                    startActivity(intent);
                    putSharedPreferencesString("login","ok","yes");//设置已经登陆
                    putSharedPreferencesString("login","user",user+"");//设置登录用户
                    Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }else{
                    Toast.makeText(getActivity(),"账号/密码错误",Toast.LENGTH_SHORT).show();
                }

            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"请重新注册",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        return view;
    }
    public void putSharedPreferencesString(String filename,String id,String con){
        SharedPreferences.Editor editor = getContext().getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putString(id,con);
        editor.apply();
    }
    public String getSharedPreferencesString(String filename,String id){
        SharedPreferences preferences =getContext().getSharedPreferences(filename,MODE_PRIVATE);
        String con = preferences.getString(id,"");
        return con;
    }
}
