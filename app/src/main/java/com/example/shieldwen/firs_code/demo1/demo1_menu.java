package com.example.shieldwen.firs_code.demo1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Mycollectdao;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Mycollect;
import com.example.shieldwen.firs_code.demo8_tomacat_jsp.demo8_tomacat;

import java.util.ArrayList;

public class demo1_menu extends AppCompatActivity{
    private static int Mycollect=1001;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private WebView webView;
    private Intent intent;
    private String getString;//从上一个活动接收的字符串
    private String user;
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1_menu);
        user =getSharedPreferencesString("login","user");
        findView();//获取焦点和点击事件
        getDate();
        android_with_jsp();

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              textView3.performClick();
            }
        },500);
    }
    public void findView(){
        textView1=findViewById(R.id.demo1_menu_back);
        textView2 = findViewById(R.id.demo1_menu_collect);
        textView3 = findViewById(R.id.demo1_menu_auto);
        webView = findViewById(R.id.demo1_menu_webview);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.equals("游客")){
                    Toast.makeText(demo1_menu.this,"请登录", Toast.LENGTH_SHORT).show();
                }else if(textView2.getText().toString().equals("已收藏")){
                    Mycollect m = new Mycollect(); m.setMenu_name(getString);
                    Mycollectdao.delete(m);
                    textView2.setText("收藏");
                }else {
                    textView2.setText("已收藏");
                    Mycollect m = new Mycollect();
                    m.setId(Mycollect++);
                    m.setMenu_name(getString);
                    Mycollectdao.insert(m);
                    Toast.makeText(demo1_menu.this, "收藏成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfoToJs(v);
            }
        });
    }
    public void getDate(){
        intent = getIntent();
        getString =intent.getStringExtra("menu_name");

    }
    private class JsInterface {
        private Context mContext;

        public JsInterface(Context context) {
            this.mContext = context;
        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void showInfoFromJs(String name) {
            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        }


    }

    //android 执行jsp中的js方法

    public void android_with_jsp(){
        webView.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        String url = "http://192.168.137.1:8080/caidao/Menu_android.jsp";
        webView.loadUrl(url);
        //在js中调用本地java方法
        webView.addJavascriptInterface(new demo1_menu.JsInterface(this), "AndroidWebView");
        //添加客户端支持
        webView.setWebChromeClient(new WebChromeClient()     );
    }

    //在java中调用js代码
    public void sendInfoToJs(View view) {
        String msg = getString;
        //调用js中的函数：showInfoFromJava(msg)
        webView.loadUrl("javascript:showInfoFromJava('" + msg + "')");
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
