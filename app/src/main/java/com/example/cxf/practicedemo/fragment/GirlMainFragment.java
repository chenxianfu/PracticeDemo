package com.example.cxf.practicedemo.fragment;

import android.os.Bundle;

import com.example.cxf.practicedemo.R;

/**
 * @auther: Created by cxf on 2018/4/19.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class GirlMainFragment extends BaseFragment{
    @Override
    public int setLayout() {
        return R.layout.fragment_base;
    }

    public static GirlMainFragment newInstance(String s) {
        GirlMainFragment fragment = new GirlMainFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", s);
        fragment.setArguments(args);
        return fragment;
    }
}
