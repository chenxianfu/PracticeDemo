package com.example.cxf.practicedemo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cxf.practicedemo.view.FixedPredicateLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxianfu on 2017/11/3.
 * title:
 * discription:
 * change:
 */

public class ImageNolimitAdater extends RecyclerView.Adapter<ImageNolimitAdater.FourImagVh>{

    private Context context;
    private List<String> lists_imagepath=new ArrayList<>();

    public ImageNolimitAdater(Buttot7Activity context, List<String> list_data) {
        this.context = context;
        this.lists_imagepath = list_data;
    }

    @Override
    public FourImagVh onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.vh_item_image, parent, false);
        return new FourImagVh(v);
    }

    @Override
    public void onBindViewHolder(FourImagVh holder, int position) {
        Log.d("onBindViewHolder lists",lists_imagepath.size()+"");

    }

    @Override
    public int getItemCount() {
        return lists_imagepath.size();
    }


    public class FourImagVh extends RecyclerView.ViewHolder {

        public ImageView pl_spec_list;

        public FourImagVh(View v) {
            super(v);
            pl_spec_list = (ImageView) v.findViewById(R.id.image);
        }
    }
}
