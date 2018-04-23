package com.example.cxf.practicedemo.api;


import com.example.cxf.practicedemo.bean.TranslationBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: 网络请求接口
 * @description:
 */

public interface ApiService {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Observable<TranslationBean> getCall();
}
