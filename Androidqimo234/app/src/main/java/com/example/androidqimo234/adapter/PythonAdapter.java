package com.example.androidqimo234.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.androidqimo234.R;
import com.example.androidqimo234.bean.PythonBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PythonAdapter extends BaseQuickAdapter<PythonBean, BaseViewHolder> {
    public PythonAdapter(@Nullable List<PythonBean> data) {
        super(R.layout.item_python, data);
    }
//绑定数据
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PythonBean pythonBean) {
        baseViewHolder.setText(R.id.textView,pythonBean.getAddress());
        baseViewHolder.setText(R.id.textView2,pythonBean.getContent());
        baseViewHolder.setText(R.id.textView3,pythonBean.getOpen_class());

    }
}
