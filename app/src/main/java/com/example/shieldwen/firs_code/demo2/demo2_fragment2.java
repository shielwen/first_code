package com.example.shieldwen.firs_code.demo2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;
import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.demo1.demo1_main;
import com.example.shieldwen.firs_code.demo1.demo1_menu_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo2_fragment2 extends Fragment {
    GridView gridView;
    List<Map<String, Object>> data;
    TextView textView1,textView2,textView3,textView4,textView5,textView6, textView7,textView8,textView9,textView10,textView11,textView12,textView13;
    TextView[]textViews =new TextView[]{textView1,textView2,textView3
            ,textView4,textView5,textView6, textView7,textView8,textView9,textView10,textView11,textView12,textView13};

    LinearLayout linearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment2, container, false);
        return view;


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();
        initGridview(0,0);
        change(0);//
    }
    public  void findView(){
        textViews[0] = getActivity().findViewById(R.id.fragment2_text1);
        textViews[1] = getActivity().findViewById(R.id.fragment2_text2);
        textViews[2] = getActivity().findViewById(R.id.fragment2_text3);
        textViews[3] = getActivity().findViewById(R.id.fragment2_text4);
        textViews[4] = getActivity().findViewById(R.id.fragment2_text5);
        textViews[5] = getActivity().findViewById(R.id.fragment2_text6);
        textViews[6] = getActivity().findViewById(R.id.fragment2_text7);
        textViews[7] = getActivity().findViewById(R.id.fragment2_text8);
        textViews[8] = getActivity().findViewById(R.id.fragment2_text9);
        textViews[9] = getActivity().findViewById(R.id.fragment2_text10);
        textViews[10] = getActivity().findViewById(R.id.fragment2_text11);
        textViews[11] = getActivity().findViewById(R.id.fragment2_text12);
        textViews[12] = getActivity().findViewById(R.id.fragment2_text13);

        linearLayout = getActivity().findViewById(R.id.demo2_fragment2_find);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),demo1_main.class);
                startActivity(intent);
            }
        });

        textViews[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(0);initGridview(0,0);
            }
        });
        textViews[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(1);initGridview(1,1);
            }
        });
        textViews[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(2);initGridview(2,2);
            }
        });
        textViews[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(3);initGridview(3,3);
            }
        });
        textViews[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(4);initGridview(4,4);
            }
        });
        textViews[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(5);initGridview(5,5);
            }
        });
        textViews[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(6);initGridview(6,6);
            }
        });
        textViews[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(7);initGridview(7,7);
            }
        });
        textViews[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(8);initGridview(8,8);
            }
        });
        textViews[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(9);initGridview(9,9);
            }
        });
        textViews[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(10);initGridview(10,10);
            }
        });
        textViews[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(11);initGridview(11,11);
            }
        });
        textViews[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(12);initGridview(12,12);
            }
        });



    }//获取焦点
    public  void change(int k){ ;
        Drawable myDrawable = getResources().getDrawable(R.color.white) ;
        textViews[k].setBackgroundDrawable(myDrawable);
        for(int i=0;i<textViews.length;i++){
            if(i!=k){
                textViews[i].setBackground(null);
            }
        }

    }//改变按钮的背景
    public String[] getName(int i){
        String [] name0= new String[]{"川菜","湘菜","粤菜","鲁菜","东北菜","西北菜","浙菜","苏菜","上海菜","京菜","闽菜","徽菜","晋菜","淮扬菜","清真客家菜","新疆菜","贵州菜","豫菜","云南菜","鄂菜","赣菜","台湾美食","香港美食"};
        String [] name1= new String[]{"煎","炒","炸红烧","煮","蒸","烧烤","焖炖","拌","烙","腌","焗","卤","榨汁","烤烩","煲","免烤","干煸","熏","酱","砂锅","干锅","煨","焯","涮"};
        String [] name2= new String[]{"酸","甜","辣","咸","香","苦","鲜","咖喱","麻辣","孜然","清淡","酸","辣","香辣","酸甜","香酥","奶香","鱼香","蒜香","五香","变态辣","椒盐","怪味","甜辣爽口","微辣","酱香","糟香","葱香","原味","蚝香","剁椒","超辣","中辣","芝士味","抹茶味","泡椒","烧烤味","咸鲜","蜜汁","蒜蓉","姜汁味","黑椒茄汁味","红油味","糖醋香草味","番茄味果味","芥末味","麻酱味","豆瓣味","家常味"};
        String [] name3= new String[]{"下饭菜","甜品","肉类","主食","私家菜","凉菜","烘焙","豆制品","煲汤","酒","海鲜水产禽类","蛋类","冰品","饮品","创意菜","下酒菜","冰激凌","小吃","零食","酱汁佐料","果酱","火锅","麻辣烫"};
        String [] name4= new String[]{"炒饭","煲仔饭","盖浇饭","焗饭","烩饭","焖饭","粥寿司饼","炒饼","意大利面","披萨面条","炒面","焖面","凉面","拌面","包子","馒头","饺子","馄饨","便当","油条","花卷","锅贴","窝头","盒子","发糕","三明治","汉堡","馕锅盔","玉米饼","卷饼","河粉","米粉","米线","肉夹馍"};
        String [] name5= new String[]{"奇","吐司","海绵蛋糕","慕斯蛋糕","奶油蛋糕","磅蛋糕","小蛋糕","翻糖蛋糕","欧式蛋糕派挞","蛋挞","马卡龙中式","糕点","月饼"};
        String [] name6= new String[]{"炸锅","原汁机","塔吉锅","乐葵料理盒","蒸箱","电压力锅"};
        String [] name7= new String[]{"早餐","午餐","下午茶","晚餐","宵夜","单身","二人世界","朋友","聚餐","户外","野炊","生日聚会","一家三口"};
        String [] name8= new String[]{"婴儿 6- 8个月","婴儿 8-10个月","婴儿 10-12个月","幼儿","学龄","前儿童","青少年","孕妇","产妇","月子餐","更年期","老年","懒人","经期","素食主义","高考考生","重体力","应酬","人群","白领","教师","司机"};
        String [] name9= new String[]{"减肥","美白","食谱","排毒养颜","紧致肌肤","丰胸","祛痘","祛斑","延缓","衰老健康"};
        String [] name10= new String[]{"补硒","补钙","补锌","补铁","补碘","对抗雾霾","防辐射","润肠通便","明目","润肺","止咳","痛经","祛湿","保肝补血","抗癌","滋阴壮阳","调节内分泌","补肾","秋冬进补","驱寒暖身","消暑解渴","清热去火","养发","消食","健脾养胃","增进食欲","提高免疫","减压","养心","催乳回奶","增重","增肌","增强记忆力"};
        String [] name11= new String[]{"降血压","降血脂","降血糖","骨质疏松","便秘腹泻","贫血","失","眠口腔溃疡","感冒","发烧","脂肪肝痛","风皮炎","夜盲症","干眼症"};
        String [] name12= new String[]{"年夜饭","腊八元宵节","清明","端午节","七夕","中秋节","立秋","情人节","圣诞节","感恩节","万圣节"};
        switch (i){
            case 0: return name0;
            case 1: return name1;
            case 2: return name2;
            case 3: return name3;
            case 4: return name4;
            case 5: return name5;
            case 6: return name6;
            case 7: return name7;
            case 8: return name8;
            case 9: return name9;
            case 10: return name10;
            case 11: return name11;
            case 12: return name12;
        }

       // String [] name0 = new String[]{"大葱烧牛肉" ,"地三鲜", "番茄炖猪软骨" ,"夫妻肺片"," 黑胡椒蟹"};
       // String [] name1 = new String[]{"虎皮鸡爪"," 琥珀糖 ","姜葱蚝煲 ","酒鬼花生 ","咖哩土豆猪肉煎饺"};
       // String [] name2 = new String[]{"可乐饼"," 老北京鸡肉卷 ","卤肉凉面"," 麻辣花椒鸡 ","麻辣小龙虾"};
        //String [] name3 = new String[]{"南瓜百合瘦肉粥 ","水果棒冰"," 酸溜土豆丝"," 香辣鸡胗炒腊肉"," 紫苏叶豚肉年糕串"}

        //  case 0: return name0;
        // case 1: return name1;
        //case 2: return name2;
        //case 3: return name3;
        return name0;
    }//获取食物名字
    public int [] getImages(int i){
        int [] image0= new int[]{R.mipmap.pic1,R.mipmap.pic2,R.mipmap.pic3,R.mipmap.pic4,R.mipmap.pic5};
        int [] image1= new int[]{R.mipmap.pic6,R.mipmap.pic7,R.mipmap.pic8,R.mipmap.pic9,R.mipmap.pic10};
        int [] image2= new int[]{R.mipmap.pic11,R.mipmap.pic12,R.mipmap.pic13,R.mipmap.pic14,R.mipmap.pic15};
        int [] image3= new int[]{R.mipmap.pic16,R.mipmap.pic17,R.mipmap.pic18,R.mipmap.pic19,R.mipmap.pic20};
        return image0;
    }//获取食物图片
    public void initGridview(int a,int b){

        gridView = getActivity().findViewById(R.id.fragment2_gridview);
        //图片数据
        int[] images = getImages(a);
        //图片编号
        final  String[] name = getName(b);
        //初始化数据
        data = new ArrayList<>();
        data.clear();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("ItemImage", images[0]);
            //如果只需要显示图片，可以不用这一行，需要同时将from和to中的相关内容删去
            map.put("ItemText", name[i]);
            data.add(map);

        }
        //from数组中的是map-key的值，to数组和from是相对应的
        String[] from = {"ItemImage", "ItemText"};
        int[] to = {R.id.image1, R.id.text1};

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getContext(), data, R.layout.fragment2_right1, from, to);
        //为GridView设置适配器
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(getActivity(),demo1_menu_list.class);
                String [] str = new String[]{"","土豆","肉","饼","粥"};
                intent1.putExtra("menu_name",str[position%4]);
                startActivity(intent1);
            }
        });

    }//初始化 右边布局

    }