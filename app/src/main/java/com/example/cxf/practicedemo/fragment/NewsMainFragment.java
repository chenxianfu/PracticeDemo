package com.example.cxf.practicedemo.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.cxf.practicedemo.R;

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

    }

}
