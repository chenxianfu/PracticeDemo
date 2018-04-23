package com.example.cxf.practicedemo.api;

import android.util.Log;

import com.example.cxf.practicedemo.Config;
import com.example.cxf.practicedemo.utils.JsonFormatUtils;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther: Created by cxf on 2018/4/20.
 * @email: chenxianfu_it@163.com
 * @title: retrofit封装
 * @description:
 */

public class ApiRetrofit {
    private static Retrofit mInstance;

    private static OkHttpClient mOKHttpClient;


    public static Retrofit getInstance() {

        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {

                if (mInstance == null) {
                    mInstance = new Retrofit.Builder()
                            .baseUrl(Config.IP)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //加这个可以将service里面call替换成observable
                            .client(getOkHttpClient())
                            .build();
                }
            }
        }

        return mInstance;

    }

    private static OkHttpClient getOkHttpClient() {
        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {
                if (mOKHttpClient == null) {
                    //setlevel用来设置日志打印的级别，共包含四个级别：NONE、BASIC 请求/响应行、HEADER  请求/响应行 + 头、BODY  请求/响应行 + 头 + 体
                     HttpLoggingInterceptor logger = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.d("okhttp_request", JsonFormatUtils.formatJson(message));
                        }
                    });

                    if (Config.DEBUG) {
                        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
                    } else {
                        logger.setLevel(HttpLoggingInterceptor.Level.NONE);
                    }
                    mOKHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(5, TimeUnit.SECONDS)
                            .readTimeout(5, TimeUnit.SECONDS)
                            .writeTimeout(5, TimeUnit.SECONDS)
                            .addInterceptor(logger)
                            .build();
                }
            }
        }
        return mOKHttpClient;
    }
}
