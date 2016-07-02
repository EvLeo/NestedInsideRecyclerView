package com.evleo.aqy.playpage.bean;

import java.util.List;

/**
 * Created by LiuYu on 2016/7/2.
 */
public class VideoInfo {
    public String VName;
    public int count;
    public List<VideoItem> videoItems;
    public int orientation;
    public boolean hasMore;

    public static class VideoItem {
        public String mName;
        public int mImage;
        public String mTimelong;
    }
}
