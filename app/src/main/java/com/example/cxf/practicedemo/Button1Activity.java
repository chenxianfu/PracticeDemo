package com.example.cxf.practicedemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxianfu_it@163.com
 * @title
 * @description
 * @date 2016/11/2
 */
public class Button1Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    protected String TAG;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle toggle;
    private ArrayAdapter arrayAdapter;
    private List<String> list_title = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_button1);

        TAG = "Button1Activity";
        initView();
        setSupportActionBar(toolbar);
//        toolbar.inflateMenu(R.menu.menu);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int i = item.getItemId();
//                if (i == R.id.menu_settings) {
//                    Toast.makeText(Button1Activity.this, "onclick", Toast.LENGTH_SHORT).show();
//                }
//                return true;
//            }
//        });

        //设置左上角的那个返回图标可用;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //在开关侧滑时设置toolbar的标题改变
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toolbar.setTitle("列表");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toolbar.setTitle("侧滑drawerLayout+fragment");
            }
        };
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);

        //设置菜单左侧菜单列表 arrayAdapter只能适配一个定义了id的textview
        arrayAdapter = new ArrayAdapter(this, R.layout.adapter_item, list_title);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);//设置监听
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        listView = (ListView) findViewById(R.id.list_left);
        list_title.add("资讯");
        list_title.add("视频");
        list_title.add("攻略");
        list_title.add("更新");
        toSetFragment(0);
    }

    private void toSetFragment(int i) {
        Fragment fragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MyFragment.ARG_PLANET_NUMBER, i);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.main_righe, fragment).commit();
        // update selected item and title, then close the drawer
       // listView.setItemChecked(i, true); 去掉貌似也能运行
        setTitle(list_title.get(i));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        toSetFragment(position);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
