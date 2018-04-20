package com.example.cxf.practicedemo.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cxf.practicedemo.Config;
import com.example.cxf.practicedemo.R;

/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: 这个是新闻的内容页
 * @description:
 */

public class NewsContentsFrament extends BaseFragment {

    private String newsTitle = "";

    private TextView textView;

    @Override
    public int setLayout() {
        return R.layout.fragment_news_content;
    }

    @Override
    protected void initView() {

        textView = view.findViewById(R.id.text);

        Bundle bundle = getArguments();
        if (bundle!=null){
            newsTitle = bundle.getString(Config.NEWS_TITLES);
            textView.setText(newsTitle);
        }
    }
}
