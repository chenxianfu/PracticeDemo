package com.example.cxf.practicedemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by chenxianfu on 2018/2/27.
 * <p> 自定义的类 为内存泄漏写
 */

public class MyApplication extends Application {


    private RefWatcher refWatcher;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);

        application =this;
        // 内存泄漏检测
        refWatcher = setupLeakCanary();
    }

    public static Context getAppContext() {
        return application;
    }

    private RefWatcher setupLeakCanary() {

        //如果当前的进程是用来给LeakCanary 进行堆分析的则return，否则会执行LeakCanary的install方法。这样我们就可以使用LeakCanary了，如果检测到某个Activity 有内存泄露，LeakCanary 就会给出提示。
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication leakApplication = (MyApplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
}
