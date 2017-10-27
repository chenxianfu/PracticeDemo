package com.example.cxf.practicedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context c;
    private Button button_1,button_2,button_3,button_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        c=this;
        initView();
        setListern();
    }

    private void setListern() {
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
    }

    private void initView() {
        button_1= (Button) findViewById(R.id.button_1);
        button_2= (Button) findViewById(R.id.button_2);
        button_3= (Button) findViewById(R.id.button_3);
        button_4= (Button) findViewById(R.id.button_4);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.button_1:

                intent.setClass(this,Button1Activity.class);
                startActivity(intent);
                break;
            case R.id.button_2:
                intent.setClass(this,Button2Activity.class);
                startActivity(intent);
                break;
            case R.id.button_3:
                intent.setClass(this,Button3Activity.class);
                startActivity(intent);
                break;
            case R.id.button_4:
                intent.setClass(this,Buttot4Activity.class);
                startActivity(intent);
                break;
        }
    }
}
