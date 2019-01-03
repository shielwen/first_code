package com.example.shieldwen.firs_code.demo7_otheractivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo1.demo1_menu_list;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.MenuDao;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Mycollectdao;
import com.example.shieldwen.firs_code.demo5_sqlite.dao.Myhistorydao;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Mycollect;
import com.example.shieldwen.firs_code.demo5_sqlite.model.Myhistory;

import java.util.ArrayList;

public class demo7_history extends AppCompatActivity {
    public ArrayList<String> list= new ArrayList<String>();
    private   ArrayAdapter<String> adapter;
    private ListView listView;
    private TextView textView,textView1;//清空 返回，
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7_history);
        findView();
        initAdapter();
    }
    public void findView(){
        Myhistorydao.querty(list);
        listView =findViewById(R.id.demo7_history_list);
        textView = findViewById(R.id.demo7_history_null);
        textView1 = findViewById(R.id.demo7_history_back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    Myhistory m = new Myhistory();
                    m.setMenu_name(list.get(i));
                    Myhistorydao.delete(m);
                }
                list.clear();
                Myhistorydao.querty(list);
                initAdapter();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                String s = list.get(position);
                intent= new Intent(demo7_history.this,demo1_menu_list.class);
                intent.putExtra("menu_name",s);
                startActivity(intent);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void initAdapter(){
        ArrayAdapter<String> adapter = new ArrayAdapter <String>(demo7_history.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }
}
