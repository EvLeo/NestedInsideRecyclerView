
# 这只是一个Demo

## 有啥用？
### 利用RecyclerView嵌套ListView、GridView，完成复杂页面的list列表展示。

## 主要代码

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



