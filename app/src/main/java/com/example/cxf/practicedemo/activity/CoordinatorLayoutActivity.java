package com.example.cxf.practicedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.adapter.HomeAdapter;

import java.util.ArrayList;

/**
 * Created by chenxianfu on 2018/2/26.
 * <p> CoordinatorLayoutActivity的页面示例应用
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    public RecyclerView rv;
    public Toolbar toolbar;
    public HomeAdapter adapter;
    public ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_coordinatorlayout);

        rv = (RecyclerView) findViewById(R.id.rv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("测试CoordinatorLayoutActivity");
//        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
//        layoutParams.setScrollFlags((AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
//                | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS));

        for (int i = 0; i < 20; i++) {
            list.add("it is" + i + "item");
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        adapter = new HomeAdapter(list, this);
        rv.setAdapter(adapter);

    }
}
