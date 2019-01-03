package com.example.shieldwen.firs_code.demo2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo1.demo1_menu;
import com.example.shieldwen.firs_code.demo1.demo1_menu_list;


public class demo2_fragment3 extends Fragment {
    Intent intent2;
    LinearLayout linearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment3,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Intent intent1 = new Intent(getActivity(),demo2_fragment3_fabu.class);
        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        try{
            TextView textView = getView().findViewById(R.id.button_fabu);
            Intent intent = getActivity().getIntent();
            String str = intent.getStringExtra("shequ");
            textView.setText(str);
        }
    catch (Exception e){
    }
        linearLayout = getActivity().findViewById(R.id.demo2_fragment_lin1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(getActivity(),demo1_menu.class);
                intent2.putExtra("menu_name","大葱烧牛肉");
                startActivity(intent2);
            }
        });


    }
}
