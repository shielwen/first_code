
/*package com.example.shieldwen.boradcast.My_Idea_All;

import android.support.v7.app.ActionBar;

//获取按钮id 实现两个功能   1：跳转另一个页面  2：Toast显示变量
class a{
    Button   button1 = (Button)findViewById(R.id.button1);
           button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent1 = new Intent(MainActivity.this,Main2Activity.class);
            startActity(intent1);
            String str = "i love you";
            Toast.makeText(MainActivity.this,"i"+str,Toast.LENGTH_SHORT).show();
        }
    });
}

//实现网络 Broadcast的实现  有网络和无网络的Toast
class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo !=null &&networkInfo.isAvailable()){
                Toast.makeText(context, "network is available",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
            }

        }
    }
    //隐藏默认标题
    class 隐藏标题{
        ActionBar actionBar =getSupportActionBar();//隐藏标题
        if(actionBar !=null){
            actionBar.hide();
        }
    }

    */