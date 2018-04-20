package com.example.cxf.practicedemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cxf.practicedemo.fragment.BaseFragment;

import java.util.List;

/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] newsTitle;
    private List<BaseFragment> fragments;

    public NewsFragmentPagerAdapter(FragmentManager fm, String[] strings,List<BaseFragment> fragment) {
        super(fm);
        this.newsTitle = strings;
        this.fragments = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return newsTitle.length;
    }

    //显示在tab上的文字
    public String getPageTitle(int positon){
        return newsTitle[positon];
    }

}
