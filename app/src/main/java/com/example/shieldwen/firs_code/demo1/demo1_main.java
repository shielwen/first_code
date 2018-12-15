package com.example.shieldwen.firs_code.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.shieldwen.firs_code.R;
import com.example.shieldwen.firs_code.a_public_class.app_menu;
import com.example.shieldwen.firs_code.a_thing_class.class_demo1_soup;

import java.util.ArrayList;
import java.util.List;

//{"粥","玉米瘦肉粥","青菜瘦肉粥","南瓜粥","大白粥","黄瓜粥","###","###","###","###","###"},
        // {"汤","西红柿蛋汤","紫菜汤","三鲜汤","酸辣汤","苦瓜汤","###","###","###","###","###"},
public class demo1_main extends AppCompatActivity {
    private Button button;
    private String str_sousuo = new String();// 搜索框输入的内容 和 其他页面导过来的
    private AutoCompleteTextView editText;
    private List<class_demo1_soup> souplist = new ArrayList <>();  //适配器里面要展示的东西
    private  Intent intent1;
    @Override//主函数
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1_main);
        app_menu.setMenu_name();
        //赋予菜
        Toast.makeText(demo1_main.this,app_menu.menu_name.length+"",Toast.LENGTH_SHORT).show();
        addAdapter1(app_menu.menu_name);//自动文本框
        button = (Button)findViewById(R.id.demo1_sousuo2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_sousuo = editText.getText().toString();
                if(str_sousuo==null){
                }else {
                    Toast.makeText(demo1_main.this,"123",Toast.LENGTH_SHORT).show();
                    intent1 = new Intent(demo1_main.this,demo1_menu_list.class);
                    intent1.putExtra("menu_name",str_sousuo);
                    startActivity(intent1);
                }
            }
        });
    }


     private  void addAdapter1(String[] a){
         ArrayAdapter<String> aa = new ArrayAdapter<String>( //创建适配器
                 this,           // Context
                 android.R.layout.simple_dropdown_item_1line,
                 //使用Android自带的简单布局
                a);
         editText = (AutoCompleteTextView) findViewById(R.id.demo1_sousuo1);
         editText.setAdapter(aa);
         editText.setThreshold(1);
     }//自动完成

}


//最简单的适配器的玩法8

/*private  String changestr=new String("瓜丝儿、山鸡丁儿、拌海蜇、龙须菜、炝冬笋、玉兰片、浇鸳鸯、烧鱼头、烧槟子、烧百合、炸豆腐、炸面筋、糖熘 儿、拔丝山药、糖焖莲子、酿山药、杏仁酪、小炒螃蟹、氽大甲、什锦葛仙米、蛤蟆鱼、扒带鱼、海鲫鱼、黄花鱼、扒海参、扒燕窝、扒鸡腿儿、扒鸡块儿、扒肉、扒面筋、扒三样儿、油泼肉、酱泼肉、炒虾黄儿、熘蟹黄儿、炒子蟹、佛手海参、炒芡子米、奶汤、翅子汤、三丝汤、熏斑鸠、卤斑鸠、海白米、烩腰丁儿、火烧茨菰、炸鹿尾儿、焖鱼头、拌皮渣儿、氽肥肠儿、清拌粉皮儿、木须菜、烹丁香、烹大肉、烹白肉、麻辣野鸡、咸肉丝儿、白肉丝儿、荸荠、一品锅、素炝春不老、清焖莲子、酸黄菜、烧萝卜、烩银耳、炒银枝儿、八宝榛子酱、黄鱼锅子、 白菜锅子、什锦锅子、汤圆子锅、菊花锅子、煮饽饽锅子、肉丁辣酱、炒肉丝儿、炒肉片、烩酸菜、烩白菜、烩豌豆、焖扁豆、氽毛豆、外加腌苤蓝丝");
    private String[] fenlei_nameSS= new  String[100];
    private  void change(){
        int i=0;
        int j=0;
        String changeTwo ="";
        for(int k=0;k<changestr.length();k++) {
            char changgeOne = changestr.charAt(i++);
            if (changgeOne != '、') {
                String changeThree = String.valueOf(changgeOne);
                changeTwo = changeTwo + changeThree;

            } else {
                Toast.makeText(demo1_main.this,changeTwo,Toast.LENGTH_SHORT).show();
                fenlei_nameSS[j++] = changeTwo;
                changeTwo = "";
            }
        }
    }*/

