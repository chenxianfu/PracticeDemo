package com.example.cxf.practicedemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.cxf.practicedemo.utils.PreferenceUtil;

/**
 * @auther: Created by cxf on 2018/4/19.
 * @email: chenxianfu_it@163.com
 * @title:  activity的基类
 * @description:
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    public static String TAG = BaseActivity.class.getSimpleName();
    public Activity activity;
    public MyApplication application;
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"=================onCreate====================");

        setContentView(setLayout());

        activity = this;
        application = (MyApplication) getApplication();
        sharedPreferences = PreferenceUtil.getPreference();
        initBaseView();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // 点击空白处，隐藏软键盘
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            hideKeyboard(event, view, this);//调用方法判断是否需要隐藏键盘
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * 根据传入控件的坐标和用户的焦点坐标，判断是否隐藏键盘，如果点击的位置在控件内，则不隐藏键盘
     *
     * @param view
     *            控件view
     * @param event
     *            焦点位置
     * @return 是否隐藏
     */
    protected void hideKeyboard(MotionEvent event, View view,
                                Activity activity) {
        try {
            if (view != null && view instanceof EditText) {
                int[] location = { 0, 0 };
                view.getLocationInWindow(location);
                int left = location[0], top = location[1], right = left
                        + view.getWidth(), bootom = top + view.getHeight();
                // 判断焦点位置坐标是否在控件内，如果位置在控件外，则隐藏键盘
                if (event.getRawX() < left || event.getRawX() > right
                        || event.getY() < top || event.getRawY() > bootom) {
                    // 隐藏键盘
                    IBinder token = view.getWindowToken();
                    InputMethodManager inputMethodManager = (InputMethodManager) activity
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(token,
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected abstract int setLayout();
    /**
     * 主要用来初始化view
     */
    protected abstract void initBaseView();




    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"=================onStart====================");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"=================onResume====================");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"=================onPause====================");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"=================onRestart====================");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"=================onStop====================");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"=================onDestroy====================");
    }
}
