package com.example.cxf.practicedemo.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.activity.BigImageDisplayActivity;
import com.example.cxf.practicedemo.view.HorizontalselectedView;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Created by cxf on 2018/4/19.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class MineFragment extends BaseFragment {
    private HorizontalselectedView hsv;
    private List<String> strings = new ArrayList<>();

    private TextView tv_viewpager_scroll;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        hsv = view.findViewById(R.id.hsv);

        tv_viewpager_scroll = view.findViewById(R.id.tv_viewpager_scroll);

        strings.add("眼底灯");
        strings.add("裂隙灯");
        strings.add("其他");
        hsv.setData(strings);


        tv_viewpager_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),BigImageDisplayActivity.class));
            }
        });
    }
}
