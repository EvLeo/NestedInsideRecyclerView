package com.evleo.aqy.playpage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.evleo.aqy.playpage.R;
import com.evleo.aqy.playpage.bean.VideoInfo;
import com.evleo.aqy.playpage.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuYu on 2016/7/1.
 */
public class StaggeredSuperAdapter extends
        RecyclerView.Adapter<StaggeredSuperAdapter.MyViewHolder> {

    private List<VideoInfo> mDatas;
    private LayoutInflater mInflater;
    private Context context;

    private List<Integer> mHeights;

    public StaggeredSuperAdapter(Context context, List<VideoInfo> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.context = context;

        mHeights = new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {
            int basepx = UIUtils.dip2px(context, 100);
            if (mDatas.get(i).orientation == StaggeredGridLayoutManager.VERTICAL) {
                mHeights.add(basepx * mDatas.get(i).count);
            } else {
                if ((mDatas.get(i).count) % 3 == 0) {
                    mHeights.add(basepx * ((mDatas.get(i).count) / 3));
                } else {
                    mHeights.add(basepx * ((mDatas.get(i).count) / 3 + 1));
                }
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_videogroup_list, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        LayoutParams lp = holder.cardView.getLayoutParams();
        lp.height = mHeights.get(position);

        holder.cardView.setLayoutParams(lp);
        VideoInfo info = mDatas.get(position);
        holder.tv_title.setText(info.VName);
        if (info.orientation == StaggeredGridLayoutManager.VERTICAL) {
            holder.listView.setVisibility(View.VISIBLE);
            holder.gridView.setVisibility(View.GONE);
            holder.listView.setAdapter(new CommonSimpleAdapter<VideoInfo.VideoItem>(context,
                    info.videoItems, R.layout.item_list_group_style) {
                @Override
                public void convert(com.evleo.aqy.playpage.adapter.ViewHolder holder,
                                    VideoInfo.VideoItem item) {
                    holder.setText(R.id.title_name, item.mName);
                }
            });

        } else {
            holder.listView.setVisibility(View.GONE);
            holder.gridView.setVisibility(View.VISIBLE);
            holder.gridView.setNumColumns(3);
            holder.gridView.setAdapter(new CommonSimpleAdapter<VideoInfo.VideoItem>(context,
                    info.videoItems, R.layout.item_grid_group_style) {
                @Override
                public void convert(com.evleo.aqy.playpage.adapter.ViewHolder holder,
                                    VideoInfo.VideoItem item) {
                    holder.setText(R.id.video_name, item.mName);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends ViewHolder {

        TextView tv_title;
        GridView gridView;
        ListView listView;
        View cardView;


        public MyViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.item_title);
            gridView = (GridView) view.findViewById(R.id.common_gridview);
            listView = (ListView) view.findViewById(R.id.common_listview);
            cardView = view.findViewById(R.id.cardView);
        }
    }
}