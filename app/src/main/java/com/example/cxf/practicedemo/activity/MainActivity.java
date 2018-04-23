package com.example.cxf.practicedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.cxf.practicedemo.BaseActivity;
import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.fragment.GirlMainFragment;
import com.example.cxf.practicedemo.fragment.MineFragment;
import com.example.cxf.practicedemo.fragment.NewsMainFragment;
import com.example.cxf.practicedemo.fragment.VideoMainFragment;
import com.example.cxf.practicedemo.rxbus.EventInfo;
import com.example.cxf.practicedemo.rxbus.RxBus;
import com.example.cxf.practicedemo.rxbus.RxEvent;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bnb;


    private NewsMainFragment newsMainFragment;
    private GirlMainFragment girlMainFragment;
    private VideoMainFragment videoMainFragment;
    private MineFragment mineFragment;

    private FragmentManager fm;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = MainActivity.class.getSimpleName();
        Log.i(TAG, "initFragment");
        initFragment(savedInstanceState); //切换不要用replace,这样每次都会新建一个实例 和将之前实例销毁掉,影响性能

        RxBus.getInstance().send(RxEvent.NoticeEvent.FINISH_ACTIVITY,new EventInfo(99));
    }

    @Override
    protected void initBaseView() {
        Log.i(TAG, "initBaseView");
        bnb = findViewById(R.id.bottom_navigation_bar);

        /**
         *  setMode() 内的参数有三种模式类型：
         *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
         *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
         *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
         *
         *
         *  setBackgroundStyle() 内的参数有三种样式
         *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
         *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
         *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
         *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
         */
        bnb.setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor(R.color.base_color) //选中的
                .setInActiveColor(R.color.app_color) //未选中的
                .setBarBackgroundColor(R.color.background_color); //背景


        /** 添加导航按钮 */

        bnb.addItem(new BottomNavigationItem(R.drawable.icon_main_home, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.icon_main_girl, "美女"))
                .addItem(new BottomNavigationItem(R.drawable.icon_main_video, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.icon_main_setting, "我的"))
                .setFirstSelectedPosition(0)
                .initialise(); //initialise 一定要放在 所有设置的最后一项

        fm = getSupportFragmentManager();
    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = fm.beginTransaction();

        if (savedInstanceState != null) {
            newsMainFragment = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment");
            girlMainFragment = (GirlMainFragment) getSupportFragmentManager().findFragmentByTag("girlMainFragment");
            videoMainFragment = (VideoMainFragment) getSupportFragmentManager().findFragmentByTag("videoMainFragment");
            mineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag("mineFragment");

        } else {
            newsMainFragment = new NewsMainFragment();
            girlMainFragment = new GirlMainFragment();
            videoMainFragment = new VideoMainFragment();
            mineFragment = new MineFragment();

            transaction.add(R.id.ll_content, newsMainFragment, "newsMainFragment");
            transaction.add(R.id.ll_content, girlMainFragment, "girlMainFragment");
            transaction.add(R.id.ll_content, videoMainFragment, "videoMainFragment");
            transaction.add(R.id.ll_content, mineFragment, "mineFragment");
        }
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {

        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                transaction.hide(girlMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(mineFragment);
                transaction.show(newsMainFragment);
                transaction.commitAllowingStateLoss();

                break;
            case 1:
                transaction.hide(newsMainFragment);
                transaction.hide(videoMainFragment);
                transaction.hide(mineFragment);
                transaction.show(girlMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 2:
                transaction.hide(newsMainFragment);
                transaction.hide(girlMainFragment);
                transaction.hide(mineFragment);
                transaction.show(videoMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            case 3:
                transaction.hide(newsMainFragment);
                transaction.hide(girlMainFragment);
                transaction.hide(videoMainFragment);
                transaction.show(mineFragment);
                transaction.commitAllowingStateLoss();
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}
