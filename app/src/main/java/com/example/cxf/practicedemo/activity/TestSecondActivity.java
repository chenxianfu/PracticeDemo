package com.example.cxf.practicedemo.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.cxf.practicedemo.BaseActivity;
import com.example.cxf.practicedemo.R;

/**
 * <pre>
 *     author : chenxianfu
 *     e-mail : chenxianfu_it@163.com
 *     time   : 2018/05/25
 *     version: 1.0
 *     desc   :
 * </pre>
 */

public class TestSecondActivity extends BaseActivity{

    private ViewPager viewPager;
    private TabLayout tabs;

    @Override
    protected int setLayout() {
        return R.layout.activity_test_first;
    }

    @Override
    protected void initBaseView() {



    }
}
