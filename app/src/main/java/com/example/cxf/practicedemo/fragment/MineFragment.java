package com.example.cxf.practicedemo.fragment;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.activity.BigImageDisplayActivity;
import com.example.cxf.practicedemo.activity.TestFirstActivity;
import com.example.cxf.practicedemo.view.HorizontalSelected2View;
import com.example.cxf.practicedemo.view.HorizontalselectedView;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Created by cxf on 2018/4/19.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class MineFragment extends BaseFragment {
    private HorizontalselectedView hsv;
    private List<String> strings = new ArrayList<>();

    private TextView tv_viewpager_scroll;
    private   HorizontalSelected2View picker;
    private ImageView imageView;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        hsv = view.findViewById(R.id.hsv);

        tv_viewpager_scroll = view.findViewById(R.id.tv_viewpager_scroll);

        strings.add("眼底灯");
        strings.add("裂隙灯");
        hsv.setData(strings);


       picker = view.findViewById(R.id.scrollPicker);
        imageView = view.findViewById(R.id.image_9);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(activity, 0, list) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                int value = getItem(position);
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(R.layout.item_text, null);
                }
                TextView view = convertView.findViewById(R.id.text1);
                view.setText("第" + value + "个");
                view.setTextColor(activity.getResources().getColor(R.color.text_black));
                return convertView;

            }
        };

        picker.setAdapter(adapter);

        picker.setOnSelectedListener(new HorizontalSelected2View.OnSelectedListener() {
            @Override
            public void selected(View v, int index) {
                ViewGroup group = (ViewGroup) picker.getChildAt(0);
                for (int i = 0; i < adapter.getCount(); i++) {
                    View view = group.getChildAt(i);
                    if (i == index) {
                        view.setBackgroundColor(0xFFFF0000);
                    } else {
                        view.setBackgroundColor(group.getDrawingCacheBackgroundColor());
                    }
                }
            }
        });

        tv_viewpager_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(activity,TestFirstActivity.class);
                activity.startActivity(intent);
            }
        });
    }

//        tv_viewpager_scroll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(),BigImageDisplayActivity.class));
//            }
//        });
//    }
}
