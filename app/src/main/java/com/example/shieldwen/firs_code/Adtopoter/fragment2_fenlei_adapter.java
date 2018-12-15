package com.example.shieldwen.firs_code.Adtopoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.fragment2_fenlei_s;

import java.util.List;

public class fragment2_fenlei_adapter extends ArrayAdapter<fragment2_fenlei_s> {
    private int resourceId;

    public fragment2_fenlei_adapter(Context context, int textViewResourId, List<fragment2_fenlei_s> objects){
        super(context,textViewResourId,objects);
        resourceId = textViewResourId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){

        fragment2_fenlei_s fenlei= getItem(position);//获取当前实例  这样就可以设置类里面的  image 和 name

        //纯粹是为了获取焦点
        View view =LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textview =(TextView)view.findViewById(R.id.fragment_left_list_s);

        //动态的设置两个属性
        textview.setText(fenlei.getName());

        return view;
    }


}