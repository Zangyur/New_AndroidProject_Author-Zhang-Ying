package com.example.androidqimo234.ui.home.python;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.androidqimo234.bean.PythonBean;
import com.example.androidqimo234.utils.NetUtils;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class PythonViewModel extends ViewModel {
    public LiveData<List<PythonBean>> getPythonList() {
        //如何返回LiveData的数据
        //需要学习网络框架
        return Transformations.map(NetUtils.get().getPythonList(), Resource::getResource);

    }
}