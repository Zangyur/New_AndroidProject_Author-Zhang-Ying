package com.example.androidqimo234.ui.chart.pie;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidqimo234.R;
import com.example.androidqimo234.base.BaseFragment2;
import com.example.androidqimo234.ui.chart.line.LineViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class PieFragment extends BaseFragment2 {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_pie, container, false);
       PieChart chart= root.findViewById(R.id.pieChart);
        PieViewModel pieViewModel=new ViewModelProvider(this).get(PieViewModel.class);
        pieViewModel.getPieList().observe(getViewLifecycleOwner(),pieBeans -> {
            //entries存储数据
            List<PieEntry> entries = new ArrayList<>();
            for (int i = 0; i < pieBeans.size(); i++) {
                entries.add(new PieEntry(pieBeans.get(i).getPercentage(),pieBeans.get(i).getSalaries()));
            }
            PieDataSet dataSet = new PieDataSet(entries, "销量占比");
            dataSet.setColors(Color.GRAY,Color.GREEN,Color.MAGENTA,Color.CYAN);
            dataSet.setValueTextColor(Color.WHITE);
            dataSet.setValueTextSize(12f);
            //设置百分比
            dataSet.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return value+"%";
                }
            });
           PieData pieData = new PieData(dataSet);
            chart.setData(pieData);
            //设置中心文本
            chart.setCenterText("点击显示\n相关数据");
            chart.setCenterTextColor(Color.BLACK);
            chart.setCenterTextSize(24f);
           //设置中心圆 的点击
            chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry e, Highlight h) {
                    //点击改变文本
                    chart.setCenterText(((PieEntry)e).getLabel()+"\n"+((PieEntry) e).getValue()+"%");
                }

                @Override
                public void onNothingSelected() {
                    //没有点击恢复文本
                    chart.setCenterText("点击显示\n相关数据");
                }
            });
            //顶部偏移
            chart.setExtraTopOffset(10f);
            chart.invalidate(); // refresh
            Legend l = chart.getLegend();
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            Description description = chart.getDescription();
            description.setText("全部陶器销量的占比情况");
            description.setTextSize(16f);
            description.setTextColor(Color.BLACK);
            description.setTextAlign(Paint.Align.CENTER);
            description.setPosition(540f, 100f);
            //设置跳出的动画
            chart.animateXY(5000,5000);
        });
        return root;
    }



}