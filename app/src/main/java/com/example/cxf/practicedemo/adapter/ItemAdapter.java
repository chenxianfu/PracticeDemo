package com.example.cxf.practicedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cxf.practicedemo.R;

import java.util.ArrayList;

/**
 * Created by chenxianfu on 2018/2/26.
 * <p>
 */

public class ItemAdapter extends BaseAdapter{

    private ArrayList<String> arrayList;
    private Context context;

    public ItemAdapter(ArrayList<String> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View view = LayoutInflater.from(context).inflate(R.layout.item_main_adapter,null);
        final TextView text_content = (TextView)view.findViewById(R.id.item_text);
        text_content.setText(position+"."+arrayList.get(position));
        return view;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
