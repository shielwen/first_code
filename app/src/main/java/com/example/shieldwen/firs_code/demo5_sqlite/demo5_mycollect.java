package com.example.shieldwen.firs_code.demo5_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Mycollectdao;

import java.util.ArrayList;

public class demo5_mycollect extends AppCompatActivity {
    public ArrayList<String> listMycollect = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_mycollect);
        Mycollectdao.query(listMycollect);
        Toast.makeText(demo5_mycollect.this,"我的"+listMycollect.get(0),Toast.LENGTH_SHORT).show();
    }
}
