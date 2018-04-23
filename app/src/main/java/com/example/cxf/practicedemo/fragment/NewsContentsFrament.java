package com.example.cxf.practicedemo.fragment;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cxf.practicedemo.Config;
import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.api.ApiRetrofit;
import com.example.cxf.practicedemo.api.ApiService;
import com.example.cxf.practicedemo.bean.TranslationBean;
import com.example.cxf.practicedemo.rxbus.EventInfo;
import com.example.cxf.practicedemo.rxbus.RxBus;
import com.example.cxf.practicedemo.rxbus.RxEvent;
import com.example.cxf.practicedemo.utils.JLog;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: 这个是新闻的内容页
 * @description:
 */

public class NewsContentsFrament extends BaseFragment {

    private String newsTitle = "";

    private TextView textView;
    private Button bt_refresh;

    @Override
    public int setLayout() {
        return R.layout.fragment_news_content;
    }

    @Override
    protected void initView() {
        TAG = NewsContentsFrament.class.getSimpleName();
        RxBus.getInstance().register(RxEvent.NoticeEvent.FINISH_ACTIVITY,this);

        textView = view.findViewById(R.id.text);
        bt_refresh = view.findViewById(R.id.bt_refresh);

        Bundle bundle = getArguments();
        if (bundle!=null){
            newsTitle = bundle.getString(Config.NEWS_TITLES);
            textView.setText(newsTitle);
        }

        bt_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGet();
            }
        });

        doGet();
    }

    private void doGet() {
        ApiRetrofit.getInstance().create(ApiService.class)
                .getCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<TranslationBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"网络请求= onSubscribe" );
                    }

                    @Override
                    public void onNext(TranslationBean translationBean) {
                        Log.d(TAG,"网络请求= onNext" );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"网络请求= onError" );

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG,"网络请求= onComplete" );

                    }
                });
    }



    public void onRxEvent(RxEvent event, EventInfo info) {
        JLog.d(TAG, "onRxEvent event:" + event + ",info:" + info);
        textView.setText(info.getIndex());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(RxEvent.NoticeEvent.FINISH_ACTIVITY,this);
    }
}
