package com.evleo.aqy.playpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.evleo.aqy.playpage.activity.BaseActivity;
import com.evleo.aqy.playpage.activity.GridSuperRecyclerActivity;
import com.evleo.aqy.playpage.activity.ListRecyclerActivity;
import com.evleo.aqy.playpage.activity.PlayVideoActivity;

/**
 * Created by LiuYu on 2016/7/1.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_open_playpage).setOnClickListener(mOnclickListener);
        findViewById(R.id.btn_liststyle).setOnClickListener(mOnclickListener);
        findViewById(R.id.btn_staggersuper).setOnClickListener(mOnclickListener);
    }

    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_open_playpage:
                    executeStartActivity(MainActivity.this, PlayVideoActivity.class);
                    break;
                case R.id.btn_liststyle:
                    executeStartActivity(MainActivity.this, ListRecyclerActivity.class);
                    break;
                case R.id.btn_staggersuper:
                    executeStartActivity(MainActivity.this, GridSuperRecyclerActivity.class);
                    break;
            }
        }
    };

    private void executeStartActivity(Context context, Class<?> clazz){
        startActivity(new Intent(context, clazz));
    }
}
