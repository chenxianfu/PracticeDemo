package com.example.cxf.practicedemo.utils;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;

import com.example.cxf.practicedemo.MyApplication;

/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: 公共方法
 * @description:
 */

public class CommontUtils {

    public static void dynamicSetTabLayoutMode(TabLayout tabLayout) {
        int tabWidth = calculateTabWidth(tabLayout);
        int screenWidth = getScreenWith();

        if (tabWidth <= screenWidth) {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        } else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }
    private static int calculateTabWidth(TabLayout tabLayout) {
        int tabWidth = 0;
        for (int i = 0; i < tabLayout.getChildCount(); i++) {
            final View view = tabLayout.getChildAt(i);
            view.measure(0, 0); // 通知父view测量，以便于能够保证获取到宽高
            tabWidth += view.getMeasuredWidth();
        }
        return tabWidth;
    }
    public static int getScreenWith() {
        return MyApplication.getAppContext().getResources().getDisplayMetrics().widthPixels;
    }
    public static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }
}
