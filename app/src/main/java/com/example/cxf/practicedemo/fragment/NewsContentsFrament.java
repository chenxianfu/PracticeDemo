package com.example.cxf.practicedemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.cxf.practicedemo.Config;
import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.adapter.NewsListAdapter;
import com.example.cxf.practicedemo.api.ApiRetrofit;
import com.example.cxf.practicedemo.api.ApiService;
import com.example.cxf.practicedemo.bean.NewsSummary;
import com.example.cxf.practicedemo.irecycleview.IRecyclerView;
import com.example.cxf.practicedemo.irecycleview.OnLoadMoreListener;
import com.example.cxf.practicedemo.irecycleview.OnRefreshListener;
import com.example.cxf.practicedemo.irecycleview.animation.ScaleInAnimation;
import com.example.cxf.practicedemo.irecycleview.widget.LoadMoreFooterView;
import com.example.cxf.practicedemo.view.LoadingTip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: 这个是新闻的内容页
 * @description:
 */

public class NewsContentsFrament extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private String newsTitle = "";

    private IRecyclerView irc;
    private LoadingTip loaded_tip;

    private NewsListAdapter adapter;
    private List<NewsSummary> list_news = new ArrayList<>();

    private int startPage;

    @Override
    public int setLayout() {
        return R.layout.fragment_news_content;
    }

    @Override
    protected void initView() {
        TAG = NewsContentsFrament.class.getSimpleName();

        Bundle bundle = getArguments();
        if (bundle!=null){
            newsTitle = bundle.getString(Config.NEWS_TITLES);
        }

        irc = view.findViewById(R.id.irc);
        loaded_tip = view.findViewById(R.id.loaded_tip);

        irc.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new NewsListAdapter(activity,list_news);
        adapter.openLoadAnimation(new ScaleInAnimation()); //动画添加
        irc.setAdapter(adapter);
        irc.setOnRefreshListener(this);
        irc.setOnLoadMoreListener(this);

        doGet();

    }

    private void doGet() {
        ApiRetrofit.getInstance().create(ApiService.class)
                .getNewsList("T1348647909107",startPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<Map<String,List<NewsSummary>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"网络请求= onSubscribe" );
                    }

                    @Override
                    public void onNext(Map<String,List<NewsSummary>> obj) {
                        List<NewsSummary> newsSummaries =  obj.get("T1348647909107");
                        irc.setRefreshing(false);
                        if (newsSummaries != null) {
                            startPage += 20;
                            if (adapter.getPageBean().isRefresh()) {

                                adapter.replaceAll(newsSummaries);
                            } else {
                                if (newsSummaries.size() > 0) {
                                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                                    adapter.addAll(newsSummaries);
                                } else {
                                    irc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                                }
                            }
                        }else {
                            loaded_tip.setLoadingTip(LoadingTip.LoadStatus.empty);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        irc.setRefreshing(false);
                        loaded_tip.setLoadingTip(LoadingTip.LoadStatus.error);
                        if (adapter.getSize()>0){
                            irc.setLoadMoreStatus(LoadMoreFooterView.Status.ERROR);
                        }

                        Log.d(TAG,"网络请求= onError" );

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG,"网络请求= onComplete" );
                        irc.setRefreshing(false);
                        loaded_tip.setLoadingTip(LoadingTip.LoadStatus.finish);
                    }
                });
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //刷新
    @Override
    public void onRefresh() {
        adapter.getPageBean().setRefresh(true);
        startPage = 0;
        //发起请求
        irc.setRefreshing(true);
        doGet();
    }

    //加载更多
    @Override
    public void onLoadMore(View loadMoreView) {
        adapter.getPageBean().setRefresh(false);
        //发起请求
        irc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        doGet();
    }
}
