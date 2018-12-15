package com.example.shieldwen.firs_code.Adtopoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.class_demo1_soup;

import java.util.List;

public class demo1_menu_adapter1 extends ArrayAdapter<class_demo1_soup> {
    private int resourceId;

    public demo1_menu_adapter1(Context context, int textViewResourId, List<class_demo1_soup> objects){
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
        TextView menu_peiliao = (TextView)view.findViewById(R.id.demo1_menu_list1_peiliao);
        menu_peiliao.setText(soup.getPeiliao());
        TextView menu_zhiliang = (TextView)view.findViewById(R.id.demo1_menu_list1_zhiliang);
        menu_zhiliang.setText(soup.getZhilaing());

        return view;
    }


}



/*
    //有关 demo1_menu的   另加代码
    //list1  获取焦点
    TextView menu_peiliao = (TextView)view.findViewById(R.id.demo1_menu_list1_peiliao);
        menu_peiliao.setText(soup.getPeiliao());
    TextView menu_zhiliang = (TextView)view.findViewById(R.id.demo1_menu_list1_zhiliang);
        menu_zhiliang.setText(soup.getZhilaing());
    //list2 获取焦点
    TextView menu_zuofa = (TextView)view.findViewById(R.id.demo1_menu_list2_zuofa);
        menu_zuofa.setText(soup.getZuofa());
    ImageView menu_image = (ImageView) view.findViewById(R.id.demo1_menu_list2_image);
        menu_image.setImageResource(soup.getZuofa_image());*/

