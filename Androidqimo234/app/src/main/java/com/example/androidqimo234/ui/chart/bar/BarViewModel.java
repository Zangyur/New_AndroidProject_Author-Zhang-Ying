package com.example.androidqimo234.ui.chart.bar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidqimo234.bean.BarBean;
import com.example.androidqimo234.bean.LineBean;

import java.util.ArrayList;
import java.util.List;

public class BarViewModel extends ViewModel {
    private MutableLiveData<List<BarBean>> barList;

    public BarViewModel() {
        barList =new MutableLiveData<>();
        String[] years = new String[]{"0-1月","1-2月","2-3月",
                "3-5月","5-8月","8-10月","10月"};
        int[] salaries1 = {6000,13000,20000,26000,35000,50000,100000};
        int[] salaries2 = {4000,10000,15000,19000,20000,40000,70000};
        //进行内容的发布
        List<BarBean> value=new ArrayList<>();
        for (int i = 0; i < years.length; i++) {
         LineBean lineBean1=   new LineBean(years[i],salaries1[i]);
         LineBean lineBean2=   new LineBean(years[i],salaries2[i]);
            value.add(new BarBean(lineBean1,lineBean2));
        }
        barList.setValue(value);
    }
    public LiveData<List<BarBean>> getBarList(){
        return barList;
    }
}