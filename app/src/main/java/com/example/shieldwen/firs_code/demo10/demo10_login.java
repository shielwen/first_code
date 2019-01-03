package com.example.shieldwen.firs_code.demo10;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shieldwen.firs_code.R;
import com.mob.MobSDK;

import lib.kingja.switchbutton.SwitchMultiButton;

public class demo10_login extends AppCompatActivity {
    demo10_fragment1 fragment1 ;
    demo10_fragment2 fragment2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo10_login);
        MobSDK.init(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        SwitchMultiButton switchMultiButton = findViewById(R.id.switchmultibutton1);
        switchMultiButton.setText("密码", "短信");
        //默认使用密码登录
        ReplaceFragment(new demo10_fragment1());
        //选择登录方式
        switchMultiButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                switch (position) {
                    case 0://使用密码登录
                        if (fragment1 == null) {
                            fragment1 = new demo10_fragment1();
                            ReplaceFragment(fragment1);
                        } else {
                            ReplaceFragment(fragment1);
                        }
                        break;
                    case 1://使用短信登录
                        if (fragment2 == null) {
                            fragment2 = new demo10_fragment2();
                            ReplaceFragment(fragment2);
                        } else {
                            ReplaceFragment(fragment2);
                        }
                        break;
                    default:
                        break;
                }
            }
        });

    }

    public void ReplaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

}