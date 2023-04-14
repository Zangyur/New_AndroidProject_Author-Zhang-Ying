package com.example.androidqimo234.ui.chart.line;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidqimo234.bean.LineBean;

import java.util.ArrayList;
import java.util.List;

public class LineViewModel extends ViewModel {
   private MutableLiveData<List<LineBean>> lineList;

    public LineViewModel() {
        lineList=new MutableLiveData<>();
        String[] years = new String[]{"0-1月","1-2月","2-3月",
                "3-5月","5-8月","8-10月","10月"};
        int[] salaries = {6000,13000,20000,26000,35000,50000,100000};
        //进行内容的发布
        List<LineBean> value=new ArrayList<>();
        for (int i = 0; i < years.length; i++) {
            value.add(new LineBean(years[i],salaries[i]));
        }
        lineList.setValue(value);
    }
    public LiveData<List<LineBean>> getLineList(){
        return lineList;
    }
}