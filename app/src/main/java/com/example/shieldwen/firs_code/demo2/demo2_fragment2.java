package com.example.shieldwen.firs_code.demo2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shieldwen.firs_code.Adtopoter.fragment2_fenlei_adapter;
import com.example.shieldwen.firs_code.Adtopoter.fragment2_right_adapter;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_thing_class.fragment2_fenlei_s;

import java.util.ArrayList;
import java.util.List;

public class demo2_fragment2 extends Fragment {

    private List<fragment2_fenlei_s> fenleiList1 = new ArrayList<>();  //适配器里面要展示的东西
    private List<fragment2_fenlei_s> fenleiList2 = new ArrayList<>();  //适配器里面要展示的东西
    ListView listView1;
    ListView listView2;
    private  String[] fenlei1={"粥","汤","热门","菜系","烘培","主食","器具","烹饪方式","口味","功效","场合","节日","##","##"};
    private String[]fenlei2={
            "玉米瘦肉粥","青菜瘦肉粥","南瓜粥","大白粥","黄瓜粥"
    };
    private String[]fenlei3={"西红柿蛋汤","紫菜汤","三鲜汤","酸辣汤","苦瓜汤"
    };
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private int adapters=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment2,container,false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bundle();
            if(adapters==1){
                initFenlei(); adapters=0;
            }
            initFenlei2();
          listClick();
        listClick2();
    }
    public void bundle(){
        listView1 = getView().findViewById(R.id.fragment2_left_list);
        listView2 = getView().findViewById(R.id.fragment2_right_list);
    }

    public void initFenlei(){
        fenleiList1.clear();
        for(int i=0;i<fenlei1.length;i++){
            fragment2_fenlei_s s = new fragment2_fenlei_s();
            s.setName(fenlei1[i]);
            fenleiList1.add(s);
        }

    }
    public void initFenlei2(){
        fenleiList2.clear();
        for(int i=0;i<fenlei2.length;i++){
            fragment2_fenlei_s s = new fragment2_fenlei_s();
            s.setName1(fenlei2[i]);
            fenleiList2.add(s);
        }
        fragment2_right_adapter adapter2 = new fragment2_right_adapter(getActivity(),R.layout.fragment2_right1,fenleiList2);
        listView2.setAdapter(adapter2);

    }
    public void initFenlei3(){
        fenleiList2.clear();
        for(int i=0;i<fenlei3.length;i++){
            fragment2_fenlei_s s = new fragment2_fenlei_s();
            s.setName1(fenlei3[i]);
            fenleiList2.add(s);
        }
        fragment2_right_adapter adapter2 = new fragment2_right_adapter(getActivity(),R.layout.fragment2_right1,fenleiList2);
        listView2.setAdapter(adapter2);

    }

    private  void listClick(){
        fragment2_fenlei_adapter adapter = new fragment2_fenlei_adapter(getActivity(),R.layout.fragment2_left_layout,fenleiList1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                fragment2_fenlei_s soup = fenleiList1.get(position);
                if(soup.getName().equals("粥")){
                    initFenlei2();
                }
                if(soup.getName().equals("汤")){
                    initFenlei3();
                }
                Toast.makeText(getActivity(),soup.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void listClick2(){
        fragment2_right_adapter adapter2 = new fragment2_right_adapter(getActivity(),R.layout.fragment2_right1,fenleiList2);
        listView2.setAdapter(adapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                fragment2_fenlei_s soup = fenleiList2.get(position);
                Toast.makeText(getActivity(),soup.getName1(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*public void replaceFragment(Fragment fragment){
        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2_right,fragment);
        fragmentTransaction.commit();
  }*/
}
