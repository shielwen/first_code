package com.example.shieldwen.firs_code.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.shieldwen.firs_code.Adtopoter.fragment3_adapter;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.fragment3_shequ;
import com.example.shieldwen.firs_code.demo1.demo1_menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class demo2_fragment3 extends Fragment {
    private List<fragment3_shequ> shequList = new ArrayList <>();
    private ListView listView;

    private EditText editText;
    private ImageView imageView;
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment3,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bundle();
        button.setOnClickListener(new View.OnClickListener() {//点击则上传
            @Override
            public void onClick(View v) {
                final String context =editText.getText().toString();//获取输入的内容
                init(context,R.drawable.first_pic2);
            }
        });
        listClick();


    }
    public void bundle(){
        listView =getView().findViewById(R.id.fragment3_list);
        editText=getView().findViewById(R.id.fragment3_bt1);
        imageView=getView().findViewById(R.id.fragment3_bt2);
        button=getView().findViewById(R.id.fragment3_bt3);
    }

    public void init(String context,int image){
        Date date =new Date();
        String hour=date.getHours()+"";
        String min =date.getMinutes()+"";
        fragment3_shequ s = new fragment3_shequ();
        s.setName("菜 道    " +
                " "+hour+":"+min);
        s.setContext(context);
        s.setImage(image);
        shequList.add(0,s);
        fragment3_adapter adapter = new fragment3_adapter(getActivity(),R.layout.fragment3_layout,shequList);
        listView.setAdapter(adapter);
        }
    private  void listClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                fragment3_shequ soup = shequList.get(position);
                Intent intent1 = new Intent(getActivity(),demo1_menu.class);
                intent1.putExtra("menu_name","玉米瘦肉粥");
                startActivity(intent1);
            }
        });
    }

    }
