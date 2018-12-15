package com.example.shieldwen.firs_code.demo2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo1.demo1_main;

import java.util.TreeMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class demo2_main extends AppCompatActivity implements View.OnClickListener {

    private int den=0;
    private  int den2=0;
    //下面四个图片的跳转焦点声明
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView buttom_textView1;

    //声明四个碎片 放在主活动中间
    private demo2_fragment1 fg1;
    private demo2_fragment2 fg2;
    private demo2_fragment3 fg3;
    private demo2_fragment4 fg4;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    //左侧滑动
    private DrawerLayout drawerLayout;//布局
    private ActionBar actionBar;//左上角按钮
    private NavigationView navigationView;//丰富左侧menu
    //nav 的点击
    private CircleImageView circleImageView;
    private TextView nav_textView1;
    //toolbar
    private Toolbar toolbar;//标题布局

    private Intent intent_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        //跳转界面1
        buildId();
        replaceFragment(new demo2_fragment1());
        changeImage(1);
        toolbar_menu();
    }
    private void  buildId(){
        imageView1 =(ImageView)findViewById(R.id.buttom_button1);
        imageView2 =(ImageView)findViewById(R.id.buttom_button2);
        imageView3 =(ImageView)findViewById(R.id.buttom_button3);
        imageView4 =(ImageView)findViewById(R.id.buttom_button4);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);

    }
    //UI  toobar ++menu++nav
    private  void toolbar_menu(){
        //右上角的按钮实现
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        //第一步  设置 简单toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar_yemian);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);

        //设置左上角的按钮 会出现左侧菜单
        actionBar=getSupportActionBar();
        actionBar.setTitle(null);
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.tab_menu_shouye1);
        }
        //丰富左侧按钮的布局  导入 menu和nav_layout
        navigationView =(NavigationView)findViewById(R.id.nav_view);
        //navigatiomView中的点击事件
           //头像和用户名的点击事件
       View headView = navigationView.getHeaderView(0);
       TextView nav_textView1 =headView.findViewById(R.id.nav_item_id1);
       nav_textView1.setOnClickListener(this);
       CircleImageView nav_circleImageView1 =headView.findViewById(R.id.nav_item_image);
       nav_circleImageView1.setOnClickListener(this);
    }

    //顶部的toolbar 的显示 和点击
 public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                //左上角的点击事件
                case android.R.id.home:
                    drawerLayout.openDrawer(GravityCompat.START);
                    break;
                    //右边的点击事件
            case R.id.toolbar_button1:
                intent_search = new Intent(demo2_main.this,demo1_main.class);
                intent_search.putExtra("fenlei_yes","no");
                startActivity(intent_search);
                break;
            case R.id.toolbar_button2:
                if(den==0){
                    putSharedPreferencesInt("data","login",0);
                    den=1;
                }else {
                    putSharedPreferencesInt("data","login",1);
                    den =0;
                }

                   break;
            default:
                break;
        }
        return true;
    }


    //UI  底部导航栏的一切   +底部点击事件 和左侧菜单点击事件
    public void changeImage(int i){
        switch (i){
            case 1:
                imageView1.setImageResource(R.drawable.tab_menu_shouye1);
                imageView2.setImageResource(R.drawable.tab_menu_shouye4);
                imageView3.setImageResource(R.drawable.tab_menu_shouye6);
                imageView4.setImageResource(R.drawable.tab_menu_shouye8);
                break;
            case 2:
                imageView1.setImageResource(R.drawable.tab_menu_shouye2);
                imageView2.setImageResource(R.drawable.tab_menu_shouye3);
                imageView3.setImageResource(R.drawable.tab_menu_shouye6);
                imageView4.setImageResource(R.drawable.tab_menu_shouye8);
                break;
            case 3:
                imageView1.setImageResource(R.drawable.tab_menu_shouye2);
                imageView2.setImageResource(R.drawable.tab_menu_shouye4);
                imageView3.setImageResource(R.drawable.tab_menu_shouye5);
                imageView4.setImageResource(R.drawable.tab_menu_shouye8);
                break;
            case 4:
                imageView1.setImageResource(R.drawable.tab_menu_shouye2);
                imageView2.setImageResource(R.drawable.tab_menu_shouye4);
                imageView3.setImageResource(R.drawable.tab_menu_shouye6);
                imageView4.setImageResource(R.drawable.tab_menu_shouye7);
                break;

        }

    }


    public void changeText(int i){

        switch (i){
            case 1:
        }
    }
    public void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_middle,fragment);
        fragmentTransaction.commit();
    }
    public void onClick(View v) {
        int change=0;
        switch (v.getId()){
            case R.id.buttom_button1:
                change =1;changeImage(change);
                    Toast.makeText(demo2_main.this,"首页",Toast.LENGTH_SHORT).show();
                    if (fg1 == null) {
                    fg1 = new demo2_fragment1();
                    replaceFragment(fg1);
                } else {
                    replaceFragment(fg1);
                }

                break;
            case R.id.buttom_button2: ;change =2;changeImage(change);
                if (fg2 == null) {
                    fg2 = new demo2_fragment2();
                    replaceFragment(fg2);
                } else {
                    replaceFragment(fg2);
                }
                break;
            case R.id.buttom_button3:
                den2= getSharedPreferencesInt("data","login");
                if (den2==1){
                    change =3;changeImage(change);
                    if (fg3 == null) {
                        fg3 = new demo2_fragment3();
                        replaceFragment(fg3);
                    } else {
                        replaceFragment(fg3);
                    }
                }else {
                    Toast.makeText(demo2_main.this,"please login!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttom_button4:
                den2= getSharedPreferencesInt("data","login");
                if (den2==1){
                    change =4;changeImage(change);
                    if (fg4 == null) {
                        fg4 = new demo2_fragment4();
                        replaceFragment(fg4);
                    } else {
                        replaceFragment(fg4);
                    }
                }else {
                    Toast.makeText(demo2_main.this,"please login  2!",Toast.LENGTH_SHORT).show();
                }


                break;
                //nav 的点击
            case R.id.nav_item_id1:
                Toast.makeText(demo2_main.this,"this is id",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_item_image:
                Toast.makeText(demo2_main.this,"。。。",Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }
    public void putSharedPreferencesString(String filename,String id,String con){
        SharedPreferences.Editor editor = getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putString(id,con);
        editor.apply();
    }
    public void putSharedPreferencesInt(String filename,String id,int con){
        SharedPreferences.Editor editor = getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putInt(id,con);
        editor.apply();
    }
    public String getSharedPreferencesString(String filename,String id){
        SharedPreferences preferences = getSharedPreferences(filename,MODE_PRIVATE);
        String con = preferences.getString(id,"");
        return con;
    }
    public int getSharedPreferencesInt(String filename,String id){
        SharedPreferences preferences = getSharedPreferences(filename,MODE_PRIVATE);
        int con = preferences.getInt(id,0);
        return con;
    }


 }

