package com.example.shieldwen.firs_code.demo7_otheractivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo1.demo1_menu_list;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Mycollectdao;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Myhistorydao;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Userdao;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Mycollect;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Myhistory;

import java.util.ArrayList;

public class demo7_collect extends AppCompatActivity {
    public   ArrayList<String> list= new ArrayList<String>();
    private   ArrayAdapter<String> adapter;
    private ListView listView;
    private TextView textView;
    private TextView textView1;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_collect);
        findView();
        initAdapter();
    }
    public void findView(){
        Mycollectdao.query(list);
        listView =findViewById(R.id.demo7_collect_list);
        textView = findViewById(R.id.demo7_collect_null);
        textView1 = findViewById(R.id.demo7_collect_back);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    Mycollect m = new Mycollect();
                    m.setMenu_name(list.get(i));
                    Mycollectdao.delete(m);
                }
                Mycollectdao.query(list);
                initAdapter();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                String s = list.get(position);
                Mycollect m = new Mycollect();
                intent = new Intent(demo7_collect.this,demo1_menu_list.class);
                intent.putExtra("menu_name",s);
                startActivity(intent);

            }
        });
    }//点击事件
    public void initAdapter(){
        ArrayAdapter<String> adapter = new ArrayAdapter <String>(demo7_collect.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }

}
