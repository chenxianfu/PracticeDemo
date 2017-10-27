package com.example.cxf.practicedemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cxf on 2016/11/16.
 */
public abstract class BaseFragment extends Fragment {
    public View view;

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

        return view;
    }

    public abstract int setLayout();
}
