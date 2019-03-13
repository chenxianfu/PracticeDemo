package com.example.cxf.practicedemo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.cxf.practicedemo.BaseActivity;
import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.rxbus.EventInfo;
import com.example.cxf.practicedemo.rxbus.RxBus;
import com.example.cxf.practicedemo.rxbus.RxEvent;
import com.example.cxf.practicedemo.utils.JLog;

/**
 * @auther: Created by cxf on 2018/4/23.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class ChangeNewItemsActivity extends BaseActivity{
    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    protected int setLayout() {
        return R.layout.activity_change_newsitems;
    }

    @Override
    protected void initBaseView() {
    }

}
