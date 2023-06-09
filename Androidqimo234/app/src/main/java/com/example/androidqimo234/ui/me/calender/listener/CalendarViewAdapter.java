package com.example.androidqimo234.ui.me.calender.listener;

import android.view.View;
import android.widget.TextView;

import com.example.wyh2012114230.bean.DateBean;


public interface CalendarViewAdapter {
    /**
     * 返回阳历、阴历两个TextView
     *
     * @param view
     * @param date
     * @return
     */
    TextView[] convertView(View view, DateBean date);
}
