package com.example.androidqimo234.ui.home;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.androidqimo234.R;
import com.example.androidqimo234.adapter.HomeAdapter;
import com.example.androidqimo234.adapter.ImageAdapter;
import com.example.androidqimo234.adapter.ImageTitleNumAdapter;
import com.example.androidqimo234.bean.NewsBean;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;
    private Banner<?, BannerAdapter<?,?>> banner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RefreshLayout refreshLayout = root.findViewById(R.id.refreshLayout);
        RecyclerView recyclerView=root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //主页适配器创建成字段
       homeAdapter = new HomeAdapter(null);
        recyclerView.setAdapter(homeAdapter);
        //适配器设置布局
        homeAdapter.setEmptyView(R.layout.empty_home);

        View headerView=inflater.inflate(R.layout.header_home,container,false);
        //让主页适配器加入头部视图
        homeAdapter.addHeaderView(headerView);
        //当内容为空时还是要显示头部视图
        homeAdapter.setHeaderWithEmptyEnable(true);
        banner=headerView.findViewById(R.id.banner);
        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
                //设置圆形指示器
//                .setIndicator(new RoundLinesIndicator(getContext()))
                //设置切换方法
                .setPageTransformer(new ZoomOutPageTransformer())
                //.setBannerGalleryMZ(20,0.8f)
                .start();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
list.add(R.drawable.pic_item_list_default);
        }
        //缺省图轮播
        banner.setAdapter(new ImageAdapter(list));
        refreshLayout.setOnRefreshListener(refresh -> {
            refresh.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            getAdList();
            getNewsList();


        });
        refreshLayout.setOnLoadMoreListener(refresh -> {
            refresh.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            Toast.makeText(getActivity(),"没有更多数据了",Toast.LENGTH_SHORT).show();
        });

       getAdList();//测试时注释
        getNewsList();
       LinearLayout linearLayout_python= headerView.findViewById(R.id.linearLayout_python);
       //设置点击监听
        linearLayout_python.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_navigation_home_to_pythonFragment2));
        //设置点击监听--实现新闻的跳转
        homeAdapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle=new Bundle();
            bundle.putString("url",homeAdapter.getData().get(position).getNewsUrl());
            Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_webFragment,
                    bundle);
        });
        return root;
    }

    private void getAdList() {
        homeViewModel.getAdList().observe(getViewLifecycleOwner(), newsBeans -> {

            banner.setAdapter(new ImageTitleNumAdapter(newsBeans));
            banner.setOnBannerListener((data,position)-> {
                Bundle bundle=new Bundle();
                //获得网址实现导航
                bundle.putString("url",((NewsBean)data).getNewsUrl());
                Navigation.findNavController(banner).navigate(R.id.action_navigation_home_to_webFragment,
                        bundle);
            });

        });
    }

    private void getNewsList() {
        homeViewModel.getNewsList().observe(getViewLifecycleOwner(), newsBeans -> {
//访问网络获得是数据传给适配器
            homeAdapter.setList(newsBeans);


        });


    }
}