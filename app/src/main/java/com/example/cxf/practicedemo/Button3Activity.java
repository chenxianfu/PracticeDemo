package com.example.cxf.practicedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.cxf.practicedemo.fragment.Fragment1;
import com.example.cxf.practicedemo.fragment.Fragment2;
import com.example.cxf.practicedemo.fragment.Fragment3;
import com.example.cxf.practicedemo.fragment.MyFragmentTabHost;


/**
 * @author chenxianfu_it@163.com
 * @title
 * @description 这个是现在利用项目的模式仿写的tabhoast +fragment
 * @date 2016/11/2
 */
public class Button3Activity extends AppCompatActivity implements View.OnClickListener {
    private final String[] titles = new String[]{"主页", "聚饰云", "朋友"};

    private final Class[] fragments = new Class[]{Fragment1.class, Fragment2.class, Fragment3.class};

    private ImageView[] arr_iv=new ImageView[3];
    private TextView[] arr_tv=new TextView[3];
    private final int[] arr_drable = new int[]{R.mipmap.index_home, R.mipmap.index_logo,R.mipmap.index_friend, };
    private final int[] arr_drable_un = new int[]{R.mipmap.index_home_un,R.mipmap.index_logo_un, R.mipmap.index_friend_un, };

    private View btn_home, btn_logo, btn_friend;
    private MyFragmentTabHost tabhost;
    private int current_index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        btn_friend.setOnClickListener(this);
        btn_logo.setOnClickListener(this);
        btn_home.setOnClickListener(this);
    }

    private void setDisplayChange(int index) {

        Log.d("button3activity","current_indext1"+index+"=="+current_index);
        arr_iv[current_index].setBackgroundResource(arr_drable[current_index]);
        arr_tv[current_index].setTextColor(getResources().getColor(R.color.text_black));
        current_index = index;
        arr_iv[current_index].setBackgroundResource(arr_drable_un[current_index]);
        arr_tv[current_index].setTextColor(getResources().getColor(R.color.app_color));
        Log.d("button3activity","current_indext2"+index+"=="+current_index);
    }

    private void initData() {
        for (int i = 0; i < fragments.length; i++) {
            TabHost.TabSpec spec = tabhost.newTabSpec(titles[i]).setIndicator(titles[i]);
            tabhost.addTab(spec, fragments[i], null);
        }
        tabhost.setCurrentTab(current_index);
    }

    private void initView() {
        tabhost = (MyFragmentTabHost) findViewById(R.id.tabhost);
        tabhost.setup(this,getSupportFragmentManager(),R.id.fl_content);
        tabhost.getTabWidget().setVisibility(View.GONE);

        btn_home = findViewById(R.id.btn_home);
        arr_iv[0] = (ImageView) findViewById(R.id.img_home);
        arr_tv[0] = (TextView) findViewById(R.id.tv_home);

        btn_friend = findViewById(R.id.btn_friend);
        arr_iv[2] = (ImageView) findViewById(R.id.img_friend);
        arr_tv[2] = (TextView) findViewById(R.id.tv_friend);

        btn_logo = findViewById(R.id.btn_logo);
        arr_iv[1] = (ImageView) findViewById(R.id.img_logo);
        arr_tv[1] = (TextView) findViewById(R.id.tv_logo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_friend:
               tabhost.setCurrentTab(2);
                setDisplayChange(2);
                break;

            case R.id.btn_home:
                tabhost.setCurrentTab(0);
                setDisplayChange(0);
                break;

            case R.id.btn_logo:
                tabhost.setCurrentTab(1);
                setDisplayChange(1);
                break;
        }
    }
}
