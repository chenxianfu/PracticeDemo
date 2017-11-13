package com.example.cxf.practicedemo;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxianfu on 2017/11/5.
 * title:
 * discription:
 * change:
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;

    private List<Picture> pictures = new ArrayList<Picture>();

    public ImageAdapter(String[] titles, Integer[] images, Context context) {
        super();
        this.context = context;


        for (int i = 0; i < images.length; i++) {
            Picture picture = new Picture(titles[i], images[i]);
            pictures.add(picture);
        }

    }

    @Override
    public int getCount() {

        if (null != pictures) {
            return pictures.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {

        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            // 获得容器
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item_imagelist, null);

            // 初始化组件
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            // 给converHolder附加一个对象
            convertView.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 给组件设置资源
        final Picture picture = pictures.get(position);
        viewHolder.image.setImageURI(Uri.parse("http://jushiyun-online.oss-cn-hangzhou.aliyuncs.com/public/images/be/d0/0b/2231e160239f981199eb59963d3768de59.jpg"));
        viewHolder.title.setText(picture.getTitle());


        Log.d("adapter", "sss=" + position + "///=" + pictures.size());
        Log.d("adapter", "sss=" + viewHolder.title.getText().toString());
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictures.remove(position);
                notifyDataSetChanged();
            }
        });


        return convertView;
    }

    class ViewHolder {
        public TextView title;
        public ImageView image;
        public ImageView image_delete;
    }

    class Picture {

        private String title;
        private int imageId;

        public Picture(String title, Integer imageId) {
            this.imageId = imageId;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public int getImageId() {
            return imageId;
        }

    }
}


