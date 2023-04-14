package com.example.androidqimo234.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.androidqimo234.R;
import com.example.androidqimo234.bean.NewsBean;
import com.example.androidqimo234.utils.NetUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeAdapter extends BaseMultiItemQuickAdapter<NewsBean, BaseViewHolder> {

    public HomeAdapter(@Nullable List<NewsBean> data) {
        super(data);
        addItemType(1, R.layout.item_home1);
        addItemType(2, R.layout.item_home2);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewsBean newsBean) {
        switch (baseViewHolder.getItemViewType()){
            //类型替换
            case 1:
                baseViewHolder.setText(R.id.textView,newsBean.getNewsName());
                baseViewHolder.setText(R.id.textView2,newsBean.getNewsTypeName());
                Glide.with(getContext()).load(NetUtils.BASE_URL+newsBean.getImg1())
                        .into((ImageView)baseViewHolder.getView(R.id.imageView));
                break;
            case 2:
                baseViewHolder.setText(R.id.textView,newsBean.getNewsName());
                baseViewHolder.setText(R.id.textView2,newsBean.getNewsTypeName());
                //图片
                Glide.with(getContext()).load(NetUtils.BASE_URL+newsBean.getImg1())
                        .into((ImageView)baseViewHolder.getView(R.id.imageView));
                Glide.with(getContext()).load(NetUtils.BASE_URL+newsBean.getImg2())
                        .into((ImageView)baseViewHolder.getView(R.id.imageView2));
                Glide.with(getContext()).load(NetUtils.BASE_URL+newsBean.getImg3())
                        .into((ImageView)baseViewHolder.getView(R.id.imageView3));
                break;
        }
    }
}
