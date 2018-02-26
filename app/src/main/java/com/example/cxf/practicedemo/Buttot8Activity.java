package com.example.cxf.practicedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cxf.practicedemo.view.FixedPredicateLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenxianfu on 2017/11/3.
 * title:
 * discription:
 * change:
 */

public class Buttot8Activity extends AppCompatActivity {


    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button8);
        imageView = (ImageView) findViewById(R.id.glide_image);

        String imageUrl ="http://img.blog.csdn.net/20161124140922633";
        Glide.with(this).load(imageUrl).into(imageView);
    }




}
