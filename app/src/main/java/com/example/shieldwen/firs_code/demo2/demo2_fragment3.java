package com.example.shieldwen.firs_code.demo2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shieldwen.firs_code.R;


public class demo2_fragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment3,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Intent intent1 = new Intent(getActivity(),demo2_fragment3_fabu.class);
        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        try{
            TextView textView = getView().findViewById(R.id.button_fabu);
            Intent intent = getActivity().getIntent();
            String str = intent.getStringExtra("shequ");
            textView.setText(str);
        }
    catch (Exception e){
    }

    }
}
