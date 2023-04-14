package com.example.androidqimo234.ui.me.calender.weigrt;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;


import androidx.viewpager.widget.PagerAdapter;

import com.example.androidqimo234.ui.me.calender.listener.CalendarViewAdapter;
import com.example.androidqimo234.utils.CalendarUtil;
import com.example.androidqimo234.utils.SolarUtil;
import com.example.wyh2012114230.bean.AttrsBean;


import java.util.LinkedList;

public class CalendarPagerAdapter extends PagerAdapter {

    //缓存上一次回收的MonthView
    private LinkedList<com.example.androidqimo234.ui.me.calender.weigrt.MonthView> cache = new LinkedList<>();
    private SparseArray<com.example.androidqimo234.ui.me.calender.weigrt.MonthView> mViews = new SparseArray<>();

    private int count;

    private int item_layout;
    private CalendarViewAdapter calendarViewAdapter;

    private AttrsBean mAttrsBean;

    public CalendarPagerAdapter(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        com.example.androidqimo234.ui.me.calender.weigrt.MonthView view;
        if (!cache.isEmpty()) {
            view = cache.removeFirst();
        } else {
            view = new com.example.androidqimo234.ui.me.calender.weigrt.MonthView(container.getContext());
        }
        //根据position计算对应年、月
        int[] date = CalendarUtil.positionToDate(position, mAttrsBean.getStartDate()[0], mAttrsBean.getStartDate()[1]);
        view.setAttrsBean(mAttrsBean);
        view.setOnCalendarViewAdapter(item_layout, calendarViewAdapter);
        view.setDateList(CalendarUtil.getMonthDate(date[0], date[1], mAttrsBean.getSpecifyMap()), SolarUtil.getMonthDays(date[0], date[1]));
        mViews.put(position, view);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((com.example.androidqimo234.ui.me.calender.weigrt.MonthView) object);
        cache.addLast((com.example.androidqimo234.ui.me.calender.weigrt.MonthView) object);
        mViews.remove(position);
    }

    /**
     * 获得ViewPager缓存的View
     *
     * @return
     */
    public SparseArray<com.example.androidqimo234.ui.me.calender.weigrt.MonthView> getViews() {
        return mViews;
    }


    public void setAttrsBean(AttrsBean attrsBean) {
        mAttrsBean = attrsBean;
    }

    public void setOnCalendarViewAdapter(int item_layout, CalendarViewAdapter calendarViewAdapter) {
        this.item_layout = item_layout;
        this.calendarViewAdapter = calendarViewAdapter;
    }
}
