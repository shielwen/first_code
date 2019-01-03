package com.example.shieldwen.firs_code.demo10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo2.demo2_main;
import com.mob.MobSDK;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static android.content.Context.MODE_PRIVATE;
import static cn.smssdk.SMSSDK.getVerificationCode;
import static com.mob.wrappers.SMSSDKWrapper.getSupportedCountries;

public class demo10_fragment2 extends Fragment {

    private static final String TAG = "MainActivity";
    EventHandler eh;
    String phone = null;
    String code = null;
    Button getcode;
    EditText editText;
    EditText editText1;
    boolean isChange;
    //控制按钮样式是否改变
    boolean tag = true;
    //每次验证请求需要间隔60S
    public int i = 60;

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case 0:
                    //客户端验证成功，可以进行注册,返回校验的手机和国家代码phone/country
                    Toast.makeText(getActivity(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    //获取验证码成功
                    Toast.makeText(getActivity(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getcode = getActivity().findViewById(R.id.getCode);
        editText = getActivity().findViewById(R.id.phone);
        editText1 = getActivity().findViewById(R.id.code);
        Button login = getActivity().findViewById(R.id.login);
        MobSDK.init(getActivity());

        eh = new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        Message msg = new Message();
                        msg.arg1 = 0;
                        msg.obj = data;
                        handler.sendMessage(msg);
                        Log.d(TAG, "提交验证码成功");
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        Message msg = new Message();
                        //获取验证码成功
                        msg.arg1 = 1;
                        msg.obj = "获取验证码成功";
                        handler.sendMessage(msg);
                        Log.d(TAG, "获取验证码成功");
                    }
                } else {
                    Message msg = new Message();
                    //返回支持发送验证码的国家列表
                    msg.arg1 = 3;
                    msg.obj = "验证失败";
                    handler.sendMessage(msg);
                    Log.d(TAG, "验证失败");
                    ((Throwable) data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh);
        getcode.setClickable(false);

        //获取验证码按钮的监听事件
        getcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = editText.getText().toString();
                if (phone.equals("")){
                    Toast.makeText(getActivity(),"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else if (isMobileNO(phone)){
                    //如果手机号码无误，则发送验证请求
                    getcode.setClickable(true);
                    changeBtnGetCode();
                    getSupportedCountries();
                    getVerificationCode("86", phone);
                }else {
                    Toast.makeText(getActivity(),"号码输入错误",Toast.LENGTH_SHORT).show();
                }

            }
        });
        //用短信登录时登录按钮的监听事件
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                code = editText1.getText().toString();
                phone = editText.getText().toString();
                if (code.equals("")||phone.equals("")){
                    Toast.makeText(getActivity(),"手机号或验证码不能为空！",Toast.LENGTH_SHORT).show();
                }else {
                    putSharedPreferencesString("login","ok","yes");//设置已经登陆
                    putSharedPreferencesString("login","user","李建文");//设置登录用户
                    Intent intent = new Intent(getActivity(),demo2_main.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_SHORT).show();
                    getActivity().finish();

                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        return view;
    }

    //判断字符串是否是电话号码
    public boolean isMobileNO(String phone) {
        String telRegex = "[1][3578]\\d{9}";
        if (TextUtils.isEmpty(phone)) return false;
        else return phone.matches(telRegex);
    }
    //获取验证码按钮的改变
    public void changeBtnGetCode() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (tag) {
                    while (i > 0) {
                        i--;
                        //如果活动为空
                        if (getActivity() == null) {
                            break;
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getcode.setText("获取验证码(" + i + ")");
                                getcode.setClickable(false);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    tag = false;
                }
                i = 60;
                tag = true;
                if (getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getcode.setText("获取验证码");
                            getcode.setClickable(true);
                        }
                    });
                }
            }
        };
        thread.start();
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