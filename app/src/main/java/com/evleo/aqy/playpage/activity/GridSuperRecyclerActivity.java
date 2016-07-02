package com.evleo.aqy.playpage.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.evleo.aqy.playpage.R;
import com.evleo.aqy.playpage.adapter.StaggeredSuperAdapter;
import com.evleo.aqy.playpage.bean.VideoInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuYu on 2016/7/1.
 */
public class GridSuperRecyclerActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<VideoInfo> mDatas;
    private StaggeredSuperAdapter mStaggeredSuperAdapter;
    private boolean hasmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liststyle);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_liststyle);
        mStaggeredSuperAdapter = new StaggeredSuperAdapter(this, mDatas);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mStaggeredSuperAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    protected void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            hasmore = !hasmore;
            VideoInfo info = new VideoInfo();
            info.orientation = (i % 2 == 0) ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL;
            if (info.orientation == StaggeredGridLayoutManager.VERTICAL) {
                info.count = 3;
            } else {
                info.count = 9;
            }
            info.hasMore = hasmore;
            info.VName = "第" + i + "种视频类型";
            info.videoItems = new ArrayList<>();
            for (int j = 0; j < info.count; j++) {
                VideoInfo.VideoItem item = new VideoInfo.VideoItem();
                item.mName = "第" + j + "段视频";
                info.videoItems.add(item);
            }
            mDatas.add(info);
        }
    }

}
