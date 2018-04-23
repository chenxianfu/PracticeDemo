package com.example.cxf.practicedemo.activity;

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
    private TextView tv_content;

    @Override
    protected int setLayout() {
        return R.layout.activity_change_newsitems;
    }

    @Override
    protected void initBaseView() {
        RxBus.getInstance().register(RxEvent.NoticeEvent.FINISH_ACTIVITY,this);

        tv_content = findViewById(R.id.tv_content);
    }

    @Override
    protected void onDestroy() {
        RxBus.getInstance().unregister(RxEvent.NoticeEvent.FINISH_ACTIVITY,this);
        super.onDestroy();
    }

    public void onRxEvent(RxEvent event, EventInfo info) {
        JLog.d(TAG, "onRxEvent event:" + event + ",info:" + info);
        tv_content.setText(info.getIndex());
    }
}
