package com.example.cxf.practicedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.cxf.practicedemo.Button1Activity;
import com.example.cxf.practicedemo.Button2Activity;
import com.example.cxf.practicedemo.Button3Activity;
import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.adapter.ItemAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private Context context;
    private GridView gridView;
    private ItemAdapter itemAdapter;

    private ArrayList<String> itemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gl_view);
        context=this;

        initItemList();
        itemAdapter = new ItemAdapter(itemList,context);
        gridView.setAdapter(itemAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toJumpActivity(position);
            }
        });

    }

    //页面跳转
    private void toJumpActivity(int position) {
        Intent intent = new Intent();
        if (0==position){
            intent.setClass(context,Button1Activity.class);

        }else if (1==position){
            intent.setClass(context,Button2Activity.class);

        }else if (2==position){
            intent.setClass(context,Button3Activity.class);

        }else if (3==position){
            intent.setClass(context,Button1Activity.class);

        }

        startActivity(intent);
    }

    //初始化数据
    private void initItemList() {
        itemList.add("主布局之侧滑fragment");
        itemList.add("主布局之TabhostFragment");
        itemList.add("主布局之viewpager+fragment");
        itemList.add("渐变效果之CoordinatorLayout");
    }

}
