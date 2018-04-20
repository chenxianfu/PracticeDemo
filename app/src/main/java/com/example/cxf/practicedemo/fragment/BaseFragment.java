package com.example.cxf.practicedemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cxf on 2016/11/16.
 */
public abstract class BaseFragment extends Fragment {
    public View view;

    public static String TAG = BaseFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(setLayout(), container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，
        // 要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = ((ViewGroup) view.getParent());
        if (parent != null) {
            parent.removeView(view);
        }

        initView();

        return view;
    }

    public abstract int setLayout();

    protected abstract void initView();


    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "=================onDetach====================");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "=================onStart====================");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "=================onResume====================");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "=================onPause====================");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "=================onStop====================");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "=================onDestroy====================");
    }
}
