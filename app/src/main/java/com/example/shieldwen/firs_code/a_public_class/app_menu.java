package com.example.shieldwen.firs_code.a_public_class;

public class app_menu {
    public  static String[] menu_name= new String[80];
    public  static String[] setMenu_name(){
        for (int i=0;i<menu_name.length;i++){
            menu_name[i]="000";
        }
        int i=0;
        menu_name[i++]="玉米瘦肉粥";  menu_name[i++]="玉带虾仁";  menu_name[i++]="红扒鱼翅";
        menu_name[i++]="青菜瘦肉粥";  menu_name[i++]="白扒通天翅";  menu_name[i++]="荔枝肉";
        menu_name[i++]="南瓜粥";  menu_name[i++]="孔府一品锅";  menu_name[i++]="纸包鸡";
        menu_name[i++]="大白粥";  menu_name[i++]="花揽桂鱼";  menu_name[i++]="焖大虾";
        menu_name[i++]="西红柿蛋汤";  menu_name[i++]="锅烧鸡";  menu_name[i++]="鱼香肉丝";
        menu_name[i++]="紫菜汤";  menu_name[i++]="麻婆豆腐";  menu_name[i++]="山东菜丸";
        menu_name[i++]="三鲜汤";  menu_name[i++]="辣子鸡丁";  menu_name[i++]="叫花鸡";
        menu_name[i++]="酸辣汤";  menu_name[i++]="东坡肘子";  menu_name[i++]="蚂蚁上树";
        menu_name[i++]="西瓜";  menu_name[i++]="豆瓣鲫鱼";  menu_name[i++]="夫妻肺片";
        menu_name[i++]="梨瓜";  menu_name[i++]="口袋豆腐";  menu_name[i++]="酸菜鱼";
       /* 鲁菜代表：玉带虾仁、、红扒鱼翅、白扒通天翅、孔府一品锅、花揽桂鱼、纸包鸡、焖大虾、锅烧鸡、山东菜丸
        川菜代表：麻婆豆腐、辣子鸡丁、东坡肘子、豆瓣鲫鱼、口袋豆腐、酸菜鱼、夫妻肺片、蚂蚁上树、叫花鸡、鱼香肉丝
        粤菜代表：咸菜焖猪肉、酿茄子、酿豆腐、梅菜扣肉、客家盐焗鸡、广式烧填鸭、烧鹅、红槽排骨、豆豉蒸排骨、煎酿三宝
        闽菜代表：佛跳墙、醉排骨、荔枝肉、扳指干贝、尤溪卜鸭、七星鱼丸汤、软溜珠廉鱼、龙身凤尾虾、油爆双脆、清炖全鸡
        苏菜代表：烤方、金陵丸子、白汁圆菜、清炖蟹粉狮子头、水晶肴蹄、鸡汤煮干丝、凤尾虾、三套鸭、无锡肉骨头、陆稿荐酱猪头肉
        浙菜代表：西湖醋鱼、东坡肉、荷叶粉蒸肉、西湖莼菜汤、龙井虾仁、虎跑素火腿、香酥焖肉、虾爆鳝背、油焖春笋
        湘菜代表：海参盆蒸、腊味合蒸、走油豆豉扣肉、麻辣子鸡、冰糖湘莲、臭豆腐、红烧寒菌、炒血鸭、湘西酸肉、蝴蝶飘海
        徽菜代表：清炖马蹄鳖、黄山炖鸽、徽州毛豆腐、鱼咬羊、香炸琵琶虾、八大锤、毛峰熏鲥鱼、香菇盒、火烘鱼、蟹黄虾盅*/
        menu_name[i++]="苦瓜汤";  menu_name[i++]="咸菜焖猪肉";  menu_name[i++]="酿茄子";
        menu_name[i++]="海参盆蒸";  menu_name[i++]="梅菜扣肉";  menu_name[i++]="客家盐焗鸡";
        menu_name[i++]="清炖马蹄鳖";  menu_name[i++]="广式烧填鸭";  menu_name[i++]="烧鹅";
        menu_name[i++]="红槽排骨";menu_name[i++]="豆豉蒸排骨";menu_name[i++]="煎酿三宝";menu_name[i++]="佛跳墙";
        menu_name[i++]="醉排骨";menu_name[i++]="荔枝肉";menu_name[i++]="扳指干贝";menu_name[i++]="尤溪卜鸭";
        menu_name[i++]="七星鱼丸汤";menu_name[i++]="软溜珠廉鱼";menu_name[i++]="龙身凤尾虾";menu_name[i++]="油爆双脆";
        menu_name[i++]="清炖全鸡";menu_name[i++]="西湖醋鱼";menu_name[i++]="东坡肉";menu_name[i++]="荷叶粉蒸肉";
        menu_name[i++]="湖莼菜汤";menu_name[i++]="龙井虾仁";menu_name[i++]="虎跑素火腿";menu_name[i++]="香酥焖肉";
        menu_name[i++]="早餐";menu_name[i++]="午餐";menu_name[i++]="晚餐";menu_name[i++]="点心";
        return  menu_name;

    }
    public static int getMenu_name_length(){
        return  menu_name.length;
    }

    /*public  static void  setMenu_name(String[] menu){
             menu_name =menu;
    }*/
}
