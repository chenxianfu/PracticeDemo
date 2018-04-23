package com.example.cxf.practicedemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.activity.ChangeNewItemsActivity;
import com.example.cxf.practicedemo.adapter.NewsFragmentPagerAdapter;
import com.example.cxf.practicedemo.Config;
import com.example.cxf.practicedemo.utils.CommontUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Created by cxf on 2018/4/19.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class NewsMainFragment extends BaseFragment{

    private Toolbar toolbar;
    private TabLayout tabs;
    private ImageView image_add_channal;
    private ViewPager view_pager;
    private FloatingActionButton fab;

    private NewsFragmentPagerAdapter adapter;
    private String[] newsTitles;
    private List<BaseFragment> fragmentList = new ArrayList<>();

    @Override
    public int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {

        tabs = view.findViewById(R.id.tabs);
        image_add_channal = view.findViewById(R.id.image_add_channal);
        view_pager = view.findViewById(R.id.view_pager);
        fab = view.findViewById(R.id.fab);

        initNewsFragments();
        adapter =new NewsFragmentPagerAdapter(getActivity().getSupportFragmentManager(),newsTitles,fragmentList);
        view_pager.setAdapter(adapter);
        tabs.setupWithViewPager(view_pager);
        CommontUtils.dynamicSetTabLayoutMode(tabs);

        image_add_channal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ChangeNewItemsActivity.class));
            }
        });
    }

    private void initNewsFragments() {
        newsTitles = getResources().getStringArray(R.array.news_titles);
        for (int i = 0; i < newsTitles.length; i++) {
            NewsContentsFrament fragment = new NewsContentsFrament();
            Bundle bundle = new Bundle();
            bundle.putString(Config.NEWS_TITLES, newsTitles[i]);
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
    }

}
