package com.example.shieldwen.firs_code.Adtopoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.class_demo1_soup;

import java.util.List;

public class soup_adapter extends ArrayAdapter<class_demo1_soup> {
    private int resourceId;

    public soup_adapter(Context context, int textViewResourId, List<class_demo1_soup>objects){
        super(context,textViewResourId,objects);
        resourceId = textViewResourId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        class_demo1_soup soup = getItem(position);//获取当前实例  这样就可以设置类里面的两个  image 和 name


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

        ImageView soup_image = (ImageView) view.findViewById(R.id.demo1_list_image);
        TextView soup_text =(TextView)view.findViewById(R.id.demo1_list_name);

        //动态的设置两个属性
        soup_image.setImageResource(soup.getImageId());
        soup_text.setText(soup.getName());


        return view;
    }


}
