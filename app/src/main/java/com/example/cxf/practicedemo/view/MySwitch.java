package com.example.cxf.practicedemo.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by chenxianfu on 2017/12/18.
 * <p>
 */

public class MySwitch extends Switch {
    public MySwitch(Context context) {
        super(context);
    }



    public MySwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MySwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 分别记录上次滑动的坐标(onInterceptTouchEvent)
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;





    private  Boolean flag;

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN: {
//
//                Log.d("bbbb","dowm");
//                flag=  false;
//                break;
//            }
//            case MotionEvent.ACTION_MOVE: {
//                Log.d("bbbb","move ");
//                int deltaX = x - mLastXIntercept;
//                int deltaY = y - mLastYIntercept;
//                //如果是左右滑动
//                if (Math.abs(deltaX) > Math.abs(deltaY)) {
//                    Log.d("bbbb","move 1");
//                    flag=  true;
//                    return flag;
//                }
//            }
//            case MotionEvent.ACTION_UP: {
//                Log.d("bbbb"," up");
//                flag=  false;
//                break;
//            }
//        }
//        mLastXIntercept = x;
//        mLastYIntercept = y;
//        return flag;
//
//    }



}
