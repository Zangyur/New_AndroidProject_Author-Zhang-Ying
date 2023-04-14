package com.example.androidqimo234.ui.home;

import androidx.lifecycle.LiveData;

import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.androidqimo234.bean.NewsBean;
import com.example.androidqimo234.utils.NetUtils;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class HomeViewModel extends ViewModel {
    public LiveData<List<NewsBean>> getNewsList() {
        //如何返回LiveData的数据
        //需要学习网络框架
        return Transformations.map(NetUtils.get().getNewsList(), Resource::getResource);

    }
    public LiveData<List<NewsBean>> getAdList() {
        //如何返回LiveData的数据
        //需要学习网络框架
        return Transformations.map(NetUtils.get().getAdList(), Resource::getResource);

    }

}