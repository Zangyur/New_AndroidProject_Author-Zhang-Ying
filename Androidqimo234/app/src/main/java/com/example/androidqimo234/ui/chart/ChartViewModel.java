package com.example.androidqimo234.ui.chart;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidqimo234.R;
import com.example.androidqimo234.bean.BoomMenuItemBean;

import java.util.ArrayList;
import java.util.List;

public class ChartViewModel extends ViewModel {

    private MutableLiveData<List<BoomMenuItemBean>> BoomMenuItemList;

    public ChartViewModel() {
        BoomMenuItemList = new MutableLiveData<>();
        List<BoomMenuItemBean> list=new ArrayList<>();
        String[] texts={"陶器瓷器","中西餐陶器","全部陶器","餐饮设备用品",
                "西餐不锈钢","酒店陶瓷","自助餐具",
                "自助餐摆件","刀叉"};
        int[] imageId={R.drawable.bat, R.drawable.bear,R.drawable.bee,
                R.drawable.butterfly,R.drawable.cat,R.drawable.dolphin, R.drawable.eagle,
                R.drawable.horse,R.drawable.elephant};
        for (int i = 0; i <texts.length ; i++) {
            //添加文本和图片
            list.add(new BoomMenuItemBean(texts[i],imageId[i]));
        }
        BoomMenuItemList.setValue(list);
    }

    public MutableLiveData<List<BoomMenuItemBean>> getBoomMenuItemList() {

        return BoomMenuItemList;
    }
}