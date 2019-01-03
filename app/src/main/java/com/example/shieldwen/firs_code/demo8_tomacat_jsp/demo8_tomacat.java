package com.example.shieldwen.firs_code.demo8_tomacat_jsp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
 import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
 import android.widget.EditText;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;

public class demo8_tomacat extends AppCompatActivity {
    private EditText nameText;
    private EditText pwdText;
    private Button button;
    private WebView webView;

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo8_tomacat);
        button = findViewById(R.id.demo8_button1);
        android_with_jsp();


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfoToJs(v);
            }
        });
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        },1000);

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
        webView = (WebView) findViewById(R.id.webView);
        webView.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        String url = "http://192.168.137.1:8080/caidao/Menu_android.jsp";
        webView.loadUrl(url);
        //在js中调用本地java方法
        webView.addJavascriptInterface(new JsInterface(this), "AndroidWebView");
        //添加客户端支持
        webView.setWebChromeClient(new WebChromeClient()     );
    }

    //在java中调用js代码
    public void sendInfoToJs(View view) {
        String msg = ((EditText) findViewById(R.id.input_et)).getText().toString()+"红烧肉";
        //调用js中的函数：showInfoFromJava(msg)
        webView.loadUrl("javascript:showInfoFromJava('" + msg + "')");
    }
}