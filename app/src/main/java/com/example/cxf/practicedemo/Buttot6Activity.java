package com.example.cxf.practicedemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by chenxianfu on 2017/10/31.
 * title:
 * discription:
 * change:
 */

public class Buttot6Activity extends AppCompatActivity {

    private TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button6);

        title = (TextView) findViewById(R.id.tv_base_title);


        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

    }
}
