package com.example.shieldwen.firs_code.demo2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_collect;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_contact;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_gengxing;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_history;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_mainActivity;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_menu;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_order;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_setting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class demo2_fragment4 extends android.support.v4.app.Fragment {
    String user;//用户
    CircleImageView circleImageView;
    TextView textView1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;
    LinearLayout linearLayout5;
    LinearLayout linearLayout6;
    LinearLayout linearLayout7;
    LinearLayout linearLayout8;
    LinearLayout linearLayout9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment4,container,false);
        return view;
    }
    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        buildle();
        setOnclick();
         user =getSharedPreferencesString("login","user");
        String username=getSharedPreferencesString(user+"","username");
        textView1.setText(username);

    }
    public void buildle(){
        circleImageView = getView().findViewById(R.id.fragment4_button0);
        textView1 = getView().findViewById(R.id.fragment4_button1);
        linearLayout3 = getView().findViewById(R.id.fragment4_button3);
        linearLayout4 = getView().findViewById(R.id.fragment4_button4);
        linearLayout5 = getView().findViewById(R.id.fragment4_button5);
        linearLayout6 = getView().findViewById(R.id.fragment4_button6);
        linearLayout7 = getView().findViewById(R.id.fragment4_button7);
        linearLayout8 = getView().findViewById(R.id.fragment4_button8);
        linearLayout9 = getView().findViewById(R.id.fragment4_button9);
    }
    public void setOnclick(){
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_mainActivity.class);
                startActivity(intent);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_mainActivity.class);
                startActivity(intent);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.equals("游客")){
                    Toast.makeText(getActivity(),"作为一个游客\n你没有权力！",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getActivity(), demo7_collect.class);
                    startActivity(intent);
                }
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.equals("游客")){
                    Toast.makeText(getActivity(),"作为一个游客\n你没有权力！",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getActivity(), demo7_history.class);
                    startActivity(intent);
                }
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_menu.class);
                startActivity(intent);
            }
        });

        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_order.class);
                startActivity(intent);
            }
        });

        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_contact.class);
                startActivity(intent);
            }
        });
        linearLayout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_gengxing.class);
                startActivity(intent);
            }
        });
        linearLayout9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo7_setting.class);
                startActivity(intent);
            }
        });

    }


    /*private void showTypeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        final AlertDialog dialog = builder.create();
        View view = View.inflate(mContext, R.layout.dialog_select_photo, null);

        TextView tv_select_gallery = (TextView) view.findViewById(R.id.tv_select_gallery);
        TextView tv_select_camera = (TextView) view.findViewById(R.id.tv_select_camera);
        dialog.setView(view);
        dialog.show();
    }*/
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

