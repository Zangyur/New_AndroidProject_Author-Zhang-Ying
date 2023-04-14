package com.example.androidqimo234.utils;

import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;
import com.github.leonardoxh.livedatacalladapter.LiveDataResponseBodyConverterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {
    //访问基础网址
    public static final String BASE_URL="http://192.168.123.187:8080/topline/";
  public static GetRequest get(){
      Retrofit retrofit=new Retrofit.Builder()
              .baseUrl(BASE_URL)
              //数据类型变换
              .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
              .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build();
   return  retrofit.create(GetRequest.class);
  }
}
