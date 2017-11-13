package com.example.cxf.practicedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxianfu on 2017/11/2.
 * title:
 * discription: 自动填充下一行的imageview
 * change:
 */

public class Buttot7Activity extends AppCompatActivity {

    private TextView tv_add_image;
    private RecyclerView rv_image_rl;
    private LinearLayoutManager manager;

    private ImageNolimitAdater adapter;
    private List<String> list_data=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button7);

        list_data.add("222");
        list_data.add("222");
        list_data.add("222");
        list_data.add("222");
        list_data.add("222");
        list_data.add("222");
        list_data.add("222");
        list_data.add("222");


        rv_image_rl = (RecyclerView) findViewById(R.id.rv_image_rl);
        manager = new GridLayoutManager(this,4);
        rv_image_rl.setLayoutManager(manager);
        adapter = new ImageNolimitAdater(this,list_data );
        rv_image_rl.setAdapter(adapter);

    }

}
