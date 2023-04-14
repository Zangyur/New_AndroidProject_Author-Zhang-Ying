package com.example.androidqimo234.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.androidqimo234.R;
import com.example.androidqimo234.bean.VideoBean;
import com.example.androidqimo234.utils.NetUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VideoAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {
    public VideoAdapter( @Nullable List<VideoBean> data) {
        super(R.layout.item_video, data);
    }
//替换视频的图片
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, VideoBean videoBean) {
        Glide.with(baseViewHolder.itemView).load(NetUtils.BASE_URL+videoBean.getImg())
                .into((ImageView)baseViewHolder.getView(R.id.imageView));
    }
}
