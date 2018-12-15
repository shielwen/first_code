package com.example.shieldwen.firs_code.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shieldwen.firs_code.Adtopoter.soup_adapter;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_public_class.app_Image;
import com.example.shieldwen.firs_code.a_public_class.app_menu;
import com.example.shieldwen.firs_code.a_thing_class.class_demo1_soup;

import java.util.ArrayList;
import java.util.List;

public class demo1_menu_list extends AppCompatActivity {
    private ListView listView;
    private Intent intent;//接收数据
    private Intent intent2;//向下传输数据
    private Intent getintent;
    private List<class_demo1_soup> souplist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1_menu_list);
        app_Image.setFragment1();
        app_menu.setMenu_name();
        addAdapter();
        getintent = getIntent();
        String str =getintent.getStringExtra("menu_name");
        initFenlei(str);
        listClick();

    }

    private  void listClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                class_demo1_soup soup = souplist.get(position);
                intent2 = new Intent(demo1_menu_list.this,demo1_menu.class);
                intent2.putExtra("menu_name",soup.getName());
                startActivity(intent2);
            }
        });
    }

    private void addAdapter(){
        soup_adapter adapter1 = new soup_adapter(demo1_menu_list.this,R.layout.activity_demo1_menu_list_layout,souplist);
        listView = (ListView)findViewById(R.id.demo1_listview);
        listView.setAdapter(adapter1);
    }
    private  void initFenlei(String name) {
        souplist.clear();
        String[] menu_name= new String[app_menu.menu_name.length];
        String[] menu_image= new String[app_menu.menu_name.length];

        for (int i = 0; i < app_menu.menu_name.length; i++) {
            menu_name[i] = "000";
        }
        int j = 0;
        for (int i = 0; i < app_menu.menu_name.length; i++) {
            if (app_menu.menu_name[i].indexOf(name) != -1) {
                menu_name[j++] = app_menu.menu_name[i];
            }
            else {}
        }

        if (menu_name[0].equals("000")||name=="nothing") {
            initNull();
        } else {
            int kk=0;
            for (int i = 0; i < j; i++) {
                class_demo1_soup soup1 = new class_demo1_soup();
                soup1.setName(menu_name[i]);
                if(kk==app_Image.fragment1_image.length){ kk=0;}
                soup1.setImageId(app_Image.fragment1_image[kk++]);
                souplist.add(soup1);
            }

        }
    }
    private  void initNull(){
        souplist.clear();
        class_demo1_soup soup1 =new class_demo1_soup();
        soup1.setName("抱歉！根据你的搜索\n什么都没有");
        soup1.setImageId(R.drawable.first_pic2);
        souplist.add(soup1);
    }
}
