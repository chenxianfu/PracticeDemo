package com.example.cxf.practicedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.cxf.practicedemo.view.FixedPredicateLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenxianfu on 2017/11/3.
 * title:
 * discription:
 * change:
 */

public class Buttot8Activity extends AppCompatActivity {
    private FixedPredicateLayout rv_image_rl;
    private boolean edit = false;
    private GridView gridview;
    private  List<Map<String, Object>> list =new ArrayList<>();
    private   ImageAdapter simple;

    private String[] titles=new String[]{
            "本地音乐","我的最爱","我的下载","我的歌单","添加"
    };

    private Integer[] images={
            R.color.red,R.drawable.delete_trans,
            R.drawable.version_background,R.drawable.red_check_solid,
            R.color.red
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button8);
        gridview = (GridView) findViewById(R.id.gv_image);

        //新建List
        ArrayList<Map<String, Object>> data_list = new ArrayList<Map<String, Object>>();
        //获取数据

        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
         simple = new ImageAdapter(titles,images,this);
        //配置适配器
        gridview.setAdapter(simple);

//       gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           @Override
//           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               Log.d("Buttot8Activity", "position=="+position);
//
//               if (position==4){
//                   Map<String, Object>  map = new HashMap<String, Object>();
//                   map.put("image",R.drawable.delete_trans );
//                   map.put("title", "最新添加");
//                   list.remove(list.size()-1);
//                   list.add(map);
//                   simple.notifyDataSetChanged();
//                   Log.d("Buttot8Activity", "position2=="+position);
//               }
//           }
//       });

    }

    private List<Map<String,Object>> getData() {
        Map<String, Object> map = null;

        String[] titles = new String[] { "本地音乐", "我的最爱", "我的下载", "我的歌单", "添加" };
        Integer[] images = { R.drawable.add_img, R.drawable.next_icon,
                R.drawable.red_check_solid, R.drawable.delete_trans, R.drawable.delete_key };

        for (int i = 0; i < images.length; i++) {
            map = new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("title", titles[i]);
            list.add(map);
        }
        return list;
    }


}
