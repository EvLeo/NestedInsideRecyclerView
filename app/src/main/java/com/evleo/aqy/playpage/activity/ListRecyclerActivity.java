package com.evleo.aqy.playpage.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.evleo.aqy.playpage.R;
import com.evleo.aqy.playpage.adapter.DividerItemDecoration;
import com.evleo.aqy.playpage.adapter.ListRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuYu on 2016/7/1.
 */
public class ListRecyclerActivity extends BaseActivity {

    private List<String> datas;
    private ListRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liststyle);
        buildDatas();
        initView();
    }

    private void initView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_liststyle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mAdapter = new ListRecyclerAdapter(this, datas));
        setClickEvent(mAdapter);
    }

    private void setClickEvent(ListRecyclerAdapter adapter) {
        adapter.setOnItemClickLitener(new ListRecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListRecyclerActivity.this, position +"has been clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(ListRecyclerActivity.this, position +"has been longclicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> buildDatas() {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("第" + (i + 1) + "段视频");
        }
        return datas;
    }


}
