package com.example.cxf.practicedemo.api;


import com.example.cxf.practicedemo.bean.GirlResult;
import com.example.cxf.practicedemo.bean.NewsSummary;
import com.example.cxf.practicedemo.bean.TranslationBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: 网络请求接口
 * @description:
 */

public interface ApiService {


    /**
     * 获取网易新闻
     * @param id
     * @param startPage
     * @return
     */
    @GET("nc/article/headline/{id}/{startPage}-20.html")
    Observable<Map<String,List<NewsSummary>>> getNewsList( @Path("id") String id, @Path("startPage") int startPage);



    /**
     * http://gank.io/api/data/福利/10/1
     * @param type 可选参数: Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * @param count
     * @param page
     * @return
     *
     * http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
     */
    @GET("api/data/{type}/{count}/{page}")
    Observable<GirlResult> getGirs(@Path("type") String type, @Path("count") int count, @Path("page") int page);
}
