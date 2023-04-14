package com.example.androidqimo234.utils;

import androidx.lifecycle.LiveData;

import com.example.androidqimo234.bean.NewsBean;
import com.example.androidqimo234.bean.PythonBean;
import com.example.androidqimo234.bean.VideoBean;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

import retrofit2.http.GET;

public interface GetRequest {
    //得到广告列表
    @GET("home_ad_list_data.json")
    LiveData<Resource<List<NewsBean>>> getAdList();
    //得到新闻列表
    @GET("home_news_list_data.json")
    LiveData<Resource<List<NewsBean>>> getNewsList();

    @GET("python_list_data.json")
    LiveData<Resource<List<PythonBean>>> getPythonList();

    @GET("video_list_data.json")
    LiveData<Resource<List<VideoBean>>> getVideoList();


}
