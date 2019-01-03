package com.example.shieldwen.firs_code.demo10;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo2.demo2_main;
import com.example.shieldwen.firs_code.demo9_login.demo9_login;
import com.example.shieldwen.firs_code.demo9_login.demo9_register;

public class demo10_loginpick extends AppCompatActivity {
    ImageView mImageView1;
    ImageView mImageView2;
    ImageView mImageView3;
    TextView mtextView;
    Intent mintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo10_loginpick);


        Button register = findViewById(R.id.demo10_loginpick_register);
        Button login = findViewById(R.id.demo10_loginpick_login);
        initViews();

        /*initViews();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        startAnimation();*/
        // 给注册按钮添加监听事件
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demo10_loginpick.this,demo9_register.class);
                startActivity(intent);
            }
        });

        //给登录按钮添加监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demo10_loginpick.this,demo10_login.class);
                startActivity(intent);
            }
        });
        mtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putSharedPreferencesString("login","user","游客");
                mintent = new Intent(demo10_loginpick.this,demo2_main.class);
                startActivity(mintent);
                finish();
            }
        });
    }
    private void initViews() {
        mImageView1 =  findViewById(R.id.image1);
        mImageView2 =  findViewById(R.id.image2);
        mImageView3 =  findViewById(R.id.image3);
        mtextView = findViewById(R.id.demo10_loginpick_text1);
    }
    private void startAnimation() {
        ObjectAnimator anim1 = new ObjectAnimator().ofFloat(mImageView1, "alpha", 1f, 0f).setDuration(5000);
        ObjectAnimator anim2 = new ObjectAnimator().ofFloat(mImageView2, "alpha", 0f, 1f).setDuration(5000);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(anim1, anim2);

        ObjectAnimator anim3 = new ObjectAnimator().ofFloat(mImageView2, "alpha", 1f, 0f).setDuration(5000);
        ObjectAnimator anim4 = new ObjectAnimator().ofFloat(mImageView3, "alpha", 0f, 1f).setDuration(5000);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim3, anim4);

        ObjectAnimator anim5 = new ObjectAnimator().ofFloat(mImageView3, "alpha", 1f, 0f).setDuration(5000);
        ObjectAnimator anim6 = new ObjectAnimator().ofFloat(mImageView1, "alpha", 0f, 1f).setDuration(5000);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(anim5, anim6);

        AnimatorSet set3 = new AnimatorSet();
        set3.playSequentially(set, set1, set2);
        set3.addListener(new AnimatorListenerAdapter() {

            private boolean mCanceled;

            @Override
            public void onAnimationStart(Animator animation) {
                mCanceled = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!mCanceled) {
                    animation.start();
                }
            }

        });
        set3.start();
    }



    public void putSharedPreferencesString(String filename,String id,String con){
        SharedPreferences.Editor editor = getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putString(id,con);
        editor.apply();
    }
    public String getSharedPreferencesString(String filename,String id){
        SharedPreferences preferences = getSharedPreferences(filename,MODE_PRIVATE);
        String con = preferences.getString(id,"");
        return con;
    }
}
