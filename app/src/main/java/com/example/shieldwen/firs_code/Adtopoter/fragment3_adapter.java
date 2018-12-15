package com.example.shieldwen.firs_code.Adtopoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.fragment3_shequ;

import java.util.List;

public class fragment3_adapter extends ArrayAdapter<fragment3_shequ> {
    private int resourceId;

    public fragment3_adapter(Context context, int textViewResourId, List<fragment3_shequ> objects){
        super(context,textViewResourId,objects);
        resourceId = textViewResourId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        fragment3_shequ fragment3 = getItem(position);//获取当前实例  这样就可以设置类里面的两个  image 和 name


        //提高效率
        View view;
        if(converView==null)
        {
            view =LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view = converView;
        }
        //纯粹是为了获取焦点

        ImageView soup_image = (ImageView) view.findViewById(R.id.fragment3_button3);
        TextView soup_text1 =(TextView)view.findViewById(R.id.fragment3_button1);
        TextView soup_text2 =(TextView)view.findViewById(R.id.fragment3_button2);

        //动态的设置两个属性
        soup_image.setImageResource(fragment3.getImage());
        soup_text1.setText(fragment3.getName());
        soup_text2.setText(fragment3.getContext());
        return view;
    }


}
