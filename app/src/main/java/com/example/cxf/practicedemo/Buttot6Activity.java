package com.example.cxf.practicedemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import com.example.cxf.practicedemo.view.TranslucentScrollView;

/**
 * Created by chenxianfu on 2017/10/31.
 * title:
 * discription: 这个页面是仿京东的toolbar渐变的主页
 * 功能点
 * 1. 轮播图
 * 2.toolbar渐变
 * 3.搜索点击切换页面
 * 4上拉加载下拉刷新
 * change:
 */

public class Buttot6Activity extends AppCompatActivity implements TranslucentScrollView.OnScrollChangedListener {

    private TranslucentScrollView scrollView;
    private Toolbar toolbar;

    private float headerHeight;//顶部高度
    private float minHeaderHeight;//顶部最低高度，即Bar的高度

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button6);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        scrollView = (TranslucentScrollView) findViewById(R.id.scrollview);
        scrollView.setOnScrollChangedListener(this);
        toolbar = (Toolbar) findViewById(R.id.home_toolbar_main);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.argb(0, 18, 176, 242));
        initMeasure();
    }

    private void initMeasure() {
        headerHeight = getResources().getDimension(R.dimen.font_size_small);
        minHeaderHeight = getResources().getDimension(R.dimen.abc_action_bar_default_height_material);

    }

    @Override
    public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
        //Y轴偏移量
        float scrollY = who.getScrollY();

        //变化率
        float headerBarOffsetY = headerHeight - minHeaderHeight;//Toolbar与header高度的差值
        float offset = 1 - Math.max((headerBarOffsetY - scrollY) / headerBarOffsetY, 0f);

        //Toolbar背景色透明度
        toolbar.setBackgroundColor(Color.argb((int) (offset * 255), 18, 176, 242));

//        //header背景图Y轴偏移
//        imgHead.setTranslationY(scrollY / 2);
    }
}
