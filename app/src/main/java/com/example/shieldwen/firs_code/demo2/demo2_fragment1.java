package com.example.shieldwen.firs_code.demo2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_public_class.app_Image;
import com.example.shieldwen.firs_code.a_public_class.app_menu;
import com.example.shieldwen.firs_code.demo1.demo1_main;
import com.example.shieldwen.firs_code.demo1.demo1_menu_list;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import static com.example.shieldwen.firs_code.a_public_class.app_Image.fragment1_image;

public class demo2_fragment1 extends Fragment implements OnBannerListener {
    private TextView textView1;
   private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;

    private TextView buttom1;
    private TextView buttom2;
    private TextView buttom3;

    private ImageView imageView;
    Intent intent;
    private String menu_name="";

    private Banner banner;
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment1,container,false);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         buildle();
        setOnclick();
        initView();
    }
//获取焦点
    private  void buildle(){
        textView1 = (TextView)getActivity().findViewById(R.id.fragment1_button1);
        textView2 = (TextView)getActivity().findViewById(R.id.fragment1_button2);
        textView3 = (TextView)getActivity().findViewById(R.id.fragment1_button3);
        textView4 = (TextView)getActivity().findViewById(R.id.fragment1_button4);
        textView5 = (TextView)getActivity().findViewById(R.id.fragment1_button5);
        textView6 = (TextView)getActivity().findViewById(R.id.fragment1_button6);
        textView7 = (TextView)getActivity().findViewById(R.id.fragment1_button7);
        textView8 = (TextView)getActivity().findViewById(R.id.fragment1_button8);
        imageView = getActivity().findViewById(R.id.demo2_fragment1_find);

        buttom1 =getActivity().findViewById(R.id.fragment1_buttom1);
        buttom2 =getActivity().findViewById(R.id.fragment1_buttom2);
        buttom3 =getActivity().findViewById(R.id.fragment1_buttom3);

    }
    //设置背景
    private void setOnclick(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(),demo1_main.class);
                startActivity(intent);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView1.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView2.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView3.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView4.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView5.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", " ");
                startActivity(intent);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView6.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", "肉");
                startActivity(intent);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView7.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", "鸡");
                startActivity(intent);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView8.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", "卤肉凉面");
                startActivity(intent);
            }
        });




       buttom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = buttom1.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", app_menu.menu_name[0]);
                startActivity(intent);
            }
        });
        buttom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = buttom2.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", app_menu.menu_name[1]);
                startActivity(intent);
            }
        });
        buttom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = buttom3.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", app_menu.menu_name[2]);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        banner = (Banner)getView().findViewById(R.id.banner);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

       //list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
       //list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
       //list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
       //list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_path.add(R.mipmap.pic9);
        list_path.add(R.mipmap.pic13);
        list_path.add(R.mipmap.pic15);
        list_path.add(R.mipmap.pic1);
        list_title.add("特色美食");
        list_title.add("高热量餐");
        list_title.add("营养午餐");
        list_title.add("膳食纤维");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();


    }
    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        String [] str = new String[]{"土豆","肉","饼","粥"};
        intent = new Intent(getActivity(),demo1_menu_list.class);
        intent.putExtra("menu_name",str[position]);
        startActivity(intent);

    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
           // Glide.with(context).load((String) path).into(imageView);
            imageView.setImageResource((Integer) path);
        }
    }

}
