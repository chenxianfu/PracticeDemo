package com.example.cxf.practicedemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author chenxianfu_it@163.com
 * @title
 * @description
 * @date 2016/11/3
 */
public class MyFragment extends Fragment {
    //,每次点击会有一个fragment
    static String ARG_PLANET_NUMBER = "planet_number";

    private TextView tv;
    private View rootView;

    public MyFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(setLayout(), container, false);
        rootView.findViewById(R.id.tv_content);
        int i = getArguments().getInt(ARG_PLANET_NUMBER);
        tv = (TextView) rootView.findViewById(R.id.tv_content);
        tv.setText((getResources().getStringArray(R.array.left_name)[i]));
        return rootView;
    }

    private int setLayout() {
        return R.layout.fragment_1;
    }


}
