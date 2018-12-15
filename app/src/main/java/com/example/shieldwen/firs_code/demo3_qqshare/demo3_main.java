package com.example.shieldwen.firs_code.demo3_qqshare;

import com.tencent.tauth.Tencent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.shieldwen.firs_code.R;

public class demo3_main extends AppCompatActivity implements OnClickListener {
    demo3_main mActivity;
    private Tencent mTencent;// 新建Tencent实例用于调用分享方法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3_main);
        bundle();

        mTencent = Tencent.createInstance("1107994822", getApplicationContext());

    }

    public void bundle() {
        Button button = (Button) findViewById(R.id.demo3_main_button1);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.demo3_main_button1:
                Toast.makeText(demo3_main.this, "123", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}