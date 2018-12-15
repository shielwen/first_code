package com.example.shieldwen.firs_code.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shieldwen.firs_code.Adtopoter.demo1_menu_adapter1;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.class_demo1_soup;
import com.example.shieldwen.firs_code.null_Null;

import java.util.ArrayList;
import java.util.List;

public class demo1_menu extends AppCompatActivity implements View.OnClickListener {

    private Intent getIntent;//获取数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1_menu);

    }

    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
