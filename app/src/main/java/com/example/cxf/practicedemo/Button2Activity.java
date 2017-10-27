package com.example.cxf.practicedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.cxf.practicedemo.fragment.Fragment1;
import com.example.cxf.practicedemo.fragment.Fragment2;
import com.example.cxf.practicedemo.fragment.Fragment3;
import com.example.cxf.practicedemo.fragment.Fragment4;

import java.util.ArrayList;

/**
 * @author chenxianfu_it@163.com
 * @title
 * @description
 * @date 2016/11/2
 */
public class Button2Activity extends AppCompatActivity {
    public FragmentTabHost tabHost;
    private LayoutInflater mInflater;
    private ArrayList<Tab> arraylist = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);

        initData();
        //setListener();
    }

    private void setListener() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId==tabHost.getCurrentTabTag()){
                    tabHost.setCurrentTab(tabHost.getCurrentTab());
                }
            }
        });
    }

    private void initData() {
        Tab  tab1= new Tab(Fragment1.class, R.string.fragment_1, R.drawable.fragment_1);
        Tab  tab2= new Tab(Fragment2.class, R.string.fragment_2, R.drawable.fragment_2);
        Tab  tab3= new Tab(Fragment3.class, R.string.fragment_3, R.drawable.fragment_3);
        Tab  tab4= new Tab(Fragment4.class, R.string.fragment_4, R.drawable.fragment_4);

        arraylist.add(tab1);
        arraylist.add(tab2);
        arraylist.add(tab3);
        arraylist.add(tab4);

        mInflater = LayoutInflater.from(this);
        //  tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost); //这里面并不是不能使用自己的ID只是必须要内外统一
        tabHost = (FragmentTabHost) findViewById(R.id.cxftab);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //取消默认的Tab间的竖线显示
        tabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        for (Tab tab:arraylist){
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            tabHost.addTab(tabSpec, tab.getFragment(), null);
        }
    }

    //给tab设置图标
    private View buildIndicator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_item, null);
        ImageView img = (ImageView) view.findViewById(R.id.imageview);
        TextView text = (TextView) view.findViewById(R.id.textview);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }
}
