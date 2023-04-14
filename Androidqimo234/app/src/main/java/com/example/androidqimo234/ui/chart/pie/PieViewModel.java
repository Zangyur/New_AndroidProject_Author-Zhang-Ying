package com.example.androidqimo234.ui.chart.pie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidqimo234.bean.PieBean;

import java.util.ArrayList;
import java.util.List;

public class PieViewModel extends ViewModel {
    private MutableLiveData<List<PieBean>> pieList;

    public PieViewModel() {
        pieList =new MutableLiveData<>();
        String[] salaries = new String[]{"中餐陶瓷","西餐陶瓷","酒店陶瓷", "西餐不锈钢"};
        int[] percentage = {50,25,15,10};
        //进行内容的发布
        List<PieBean> value=new ArrayList<>();
        for (int i = 0; i < salaries.length; i++) {
            value.add(new PieBean(salaries[i],percentage[i]));
        }
        pieList.setValue(value);
    }
    public LiveData<List<PieBean>> getPieList(){
        return pieList;
    }
}