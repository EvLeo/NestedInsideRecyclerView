package com.evleo.aqy.playpage.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.TextView;

import com.evleo.aqy.playpage.R;
import com.evleo.aqy.playpage.adapter.CommonSimpleAdapter;
import com.evleo.aqy.playpage.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuYu on 2016/7/1.
 */
public class PlayVideoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playpage);
        initView();
    }

    private void initView() {
        ListView mListView = (ListView) findViewById(R.id.lv_video);
        List<String> mDatas = buildDatas();

        mListView.setAdapter(new CommonSimpleAdapter<String>(
                getApplicationContext(), mDatas, R.layout.item_video_list) {
            @Override
            public void convert(ViewHolder holder, String item) {
                holder.setText(R.id.item_desc, item);
            }
        });

    }

    private List<String> buildDatas() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("第" + (i + 1) + "段视频");
        }
        return datas;
    }

}
