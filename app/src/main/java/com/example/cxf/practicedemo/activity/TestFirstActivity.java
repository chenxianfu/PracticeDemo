package com.example.cxf.practicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cxf.practicedemo.BaseActivity;
import com.example.cxf.practicedemo.Config;
import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.adapter.NewsFragmentPagerAdapter;
import com.example.cxf.practicedemo.fragment.BaseFragment;
import com.example.cxf.practicedemo.fragment.NewsContentsFrament;
import com.example.cxf.practicedemo.fragment.NoContentFragment;
import com.example.cxf.practicedemo.utils.CommontUtils;
import com.example.cxf.practicedemo.utils.JLog;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : chenxianfu
 *     e-mail : chenxianfu_it@163.com
 *     time   : 2018/05/25
 *     version: 1.0
 *     desc   :
 * </pre>
 */

public class TestFirstActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabs;
    private NewsFragmentPagerAdapter adapter;
    private String[] newsTitles;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private Button bt_change;
    private Button bt_change2;
    private Button bt_change3;
    private Button bt_change4;

    @Override
    protected int setLayout() {
        return R.layout.activity_test_first;
    }

    @Override
    protected void initBaseView() {

        viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        bt_change = findViewById(R.id.bt_change);
        bt_change2 = findViewById(R.id.bt_change2);
        bt_change3 = findViewById(R.id.bt_change3);
        bt_change4 = findViewById(R.id.bt_change4);

        initNewsFragments();
        newsTitles = getResources().getStringArray(R.array.news_titles);
        adapter = new NewsFragmentPagerAdapter(getSupportFragmentManager(), newsTitles, fragmentList);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE); //设置滑动


        bt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsTitles = getResources().getStringArray(R.array.news_titles_2);
                adapter = new NewsFragmentPagerAdapter(getSupportFragmentManager(), newsTitles, fragmentList);
                viewPager.setAdapter(adapter);
                tabs.setupWithViewPager(viewPager);
                tabs.setTabMode(TabLayout.MODE_SCROLLABLE); //设置滑动
            }
        });

        bt_change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsTitles = getResources().getStringArray(R.array.news_titles_3);
                adapter = new NewsFragmentPagerAdapter(getSupportFragmentManager(), newsTitles, fragmentList);
                viewPager.setAdapter(adapter);
                tabs.setupWithViewPager(viewPager);
                tabs.setTabMode(TabLayout.MODE_SCROLLABLE); //设置滑动
            }
        });
        bt_change3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsTitles = getResources().getStringArray(R.array.news_titles_4);
                adapter = new NewsFragmentPagerAdapter(getSupportFragmentManager(), newsTitles, fragmentList);
                viewPager.setAdapter(adapter);
                tabs.setupWithViewPager(viewPager);
                tabs.setTabMode(TabLayout.MODE_SCROLLABLE); //设置滑动
            }
        });
        bt_change4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              JLog.d("tag","titie="+tabs.getSelectedTabPosition() + adapter.getPageTitle(tabs.getSelectedTabPosition())); ;
            }
        });
    }


    private void initNewsFragments() {
        newsTitles = getResources().getStringArray(R.array.news_titles_2);
        for (int i = 0; i < newsTitles.length; i++) {
            NoContentFragment fragment = new NoContentFragment();
            fragmentList.add(fragment);
        }
    }

    private void initNewsFragments2() {
        fragmentList.clear();
        for (int i = 0; i < newsTitles.length; i++) {
            NoContentFragment fragment = new NoContentFragment();
            fragmentList.add(fragment);
        }
    }
}
