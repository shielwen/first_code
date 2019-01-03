package com.example.shieldwen.firs_code.demo2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
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
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_collect;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_contact;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_gengxing;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_history;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_mainActivity;
import com.example.shieldwen.firs_code.demo7_otheractivity.demo7_setting;

import java.util.TreeMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class demo2_main extends AppCompatActivity implements View.OnClickListener{

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
    private DrawerLayout drawerLayout;
    //添加布局后的 左侧滑动
    private NavigationView navigationView;

    //左侧滑动 头像与名字 的点击
    private CircleImageView circleImageView;
    private TextView nav_textView1;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        putSharedPreferencesInt("data","login",1);
        //跳转界面1
        buildId();//获取焦点
        replaceFragment(new demo2_fragment1());//初始化第一个碎片
        changeImage(1);//切换图片
        navigationView();
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

    }//获取焦点
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

    }//修改图片
    public void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_middle,fragment);
        fragmentTransaction.commit();
    }//切换中间碎片

    public void onClick(View v) {
        int change=0;
        switch (v.getId()){
            case R.id.buttom_button1:
                change =1;changeImage(change);
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
                default:
                    break;
        }
    }//点击事件

    public void navigationView(){
        navigationView=findViewById(R.id.nav_view1);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_item_image:
                        intent=new Intent(demo2_main.this,demo7_mainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_1:
                        intent=new Intent(demo2_main.this,demo7_collect.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_2:
                        intent=new Intent(demo2_main.this,demo7_history.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_3:
                        intent=new Intent(demo2_main.this,demo7_contact.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_4:
                        intent=new Intent(demo2_main.this,demo7_setting.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_5:
                        intent=new Intent(demo2_main.this,demo7_gengxing.class);
                        startActivity(intent);
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }//左侧滑动的下半部分的点击事件



    //缓存文件  一般不用
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
    public void putSharedPreferencesInt(String filename,String id,int con){
        SharedPreferences.Editor editor = getSharedPreferences(filename,MODE_PRIVATE).edit();
        editor.putInt(id,con);
        editor.apply();
    }
    public int getSharedPreferencesInt(String filename,String id){
        SharedPreferences preferences = getSharedPreferences(filename,MODE_PRIVATE);
        int con = preferences.getInt(id,0);
        return con;
    }



 }

