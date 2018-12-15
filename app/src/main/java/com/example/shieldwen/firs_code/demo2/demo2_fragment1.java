package com.example.shieldwen.firs_code.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_public_class.app_Image;
import com.example.shieldwen.firs_code.demo1.demo1_menu_list;

import static com.example.shieldwen.firs_code.a_public_class.app_Image.fragment1_image;

public class demo2_fragment1 extends Fragment {
   private TextView textView0;
    private TextView textView1;
   private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    Intent intent;
    private String menu_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment1,container,false);
        app_Image.setFragment1();

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         buildle();
        setOnclick();
    }
//获取焦点
    private  void buildle(){
        textView0 = (TextView)getActivity().findViewById(R.id.fragment1_button0);
         textView1 = (TextView)getActivity().findViewById(R.id.fragment1_button1);
        textView2 = (TextView)getActivity().findViewById(R.id.fragment1_button2);
        textView3 = (TextView)getActivity().findViewById(R.id.fragment1_button3);
        textView4 = (TextView)getActivity().findViewById(R.id.fragment1_button4);
        textView5 = (TextView)getActivity().findViewById(R.id.fragment1_button5);
        textView6 = (TextView)getActivity().findViewById(R.id.fragment1_button6);
        textView7 = (TextView)getActivity().findViewById(R.id.fragment1_button7);
        textView8 = (TextView)getActivity().findViewById(R.id.fragment1_button8);
        textView9 = (TextView)getActivity().findViewById(R.id.fragment1_button9);
        textView10 = (TextView)getActivity().findViewById(R.id.fragment1_button10);
        textView11 = (TextView)getActivity().findViewById(R.id.fragment1_button11);
        textView12= (TextView)getActivity().findViewById(R.id.fragment1_button12);

    }
    //设置背景
    private void setBackground(){
        textView0.setBackgroundResource(fragment1_image[0]);
        textView1.setBackgroundResource(fragment1_image[5]);
        textView2.setBackgroundResource(fragment1_image[6]);
        textView3.setBackgroundResource(fragment1_image[7]);
        textView4.setBackgroundResource(fragment1_image[8]);
        textView5.setBackgroundResource(fragment1_image[9]);
        textView6.setBackgroundResource(fragment1_image[10]);
        textView7.setBackgroundResource(fragment1_image[11]);
        textView8.setBackgroundResource(fragment1_image[12]);
        textView9.setBackgroundResource(fragment1_image[13]);
        textView10.setBackgroundResource(fragment1_image[14]);
        textView11.setBackgroundResource(fragment1_image[15]);
        textView12.setBackgroundResource(fragment1_image[16]);

    }
    private void setOnclick(){
        textView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView0.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
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
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView6.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView7.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView8.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView12.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView9.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView10.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = textView11.getText().toString();
                intent = new Intent(getActivity(),demo1_menu_list.class);
                intent.putExtra("menu_name", menu_name);
                startActivity(intent);
            }
        });


    }

}
