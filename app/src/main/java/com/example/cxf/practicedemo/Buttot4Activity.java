package com.example.cxf.practicedemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TableLayout;
import android.support.design.widget.TabLayout;

import com.example.cxf.practicedemo.fragment.SimpleFragmentAdapter;


/**
 * Created by cxf on 2016/11/23.
 *    这个页面是用tablayout+viewpager实现
 */
public class Buttot4Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SimpleFragmentAdapter myFragmentPagerAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_button4);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        myFragmentPagerAdapter = new SimpleFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);


        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);

//        //指定Tab的位置
//        one = mTabLayout.getTabAt(0);
//        two = mTabLayout.getTabAt(1);
//        three = mTabLayout.getTabAt(2);

    }


}
