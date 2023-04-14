package com.example.androidqimo234.ui.me;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;

import com.example.androidqimo234.R;
import com.example.androidqimo234.activity.CalendarActivity;
import com.example.androidqimo234.activity.ConstellationActivity;
import com.example.androidqimo234.activity.ScrawActivity;
import com.example.androidqimo234.activity.SettingActivity;
import com.example.androidqimo234.bean.User;


import cn.bmob.v3.BmobUser;
import de.hdodenhof.circleimageview.CircleImageView;


public class MeFragment extends Fragment {


    private boolean isLogin;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_me,container,false);
        CircleImageView circleImageView=root.findViewById(R.id.circleImageView);
        circleImageView.setOnClickListener(this::click);
        TextView textView=root.findViewById(R.id.textView);
        LinearLayout calender=root.findViewById(R.id.calender);
        LinearLayout ll_constellation = (LinearLayout) root.findViewById(R.id.ll_constellation);
        LinearLayout ll_scraw = (LinearLayout) root.findViewById(R.id.ll_scraw);
        LinearLayout rl_setting = (LinearLayout) root.findViewById(R.id.rl_setting);
        textView.setOnClickListener(this::click);
        calender.setOnClickListener(this::click);
        ll_constellation.setOnClickListener(this::click);
        ll_scraw.setOnClickListener(this::click);
        rl_setting.setOnClickListener(this::click);
        if (BmobUser.isLogin()) {
            User user = BmobUser.getCurrentUser(User.class);
            textView.setText(user.getUsername());
            isLogin=true;

        } else {
            textView.setText("点击登录");
            isLogin=false;

        }
        LinearLayout linearLayout_map=root.findViewById(R.id.linerLayout_map);
        linearLayout_map.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_navigation_me_to_mapFragment));
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendarIntent = new Intent(getActivity(), CalendarActivity.class);
                startActivity(calendarIntent);


            }
        });
        ll_constellation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ConstellationIntent = new Intent(getActivity(), ConstellationActivity.class);
                startActivity(ConstellationIntent);
            }
        });
        ll_scraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ScrawIntent = new Intent(getActivity(), ScrawActivity.class);
                startActivity(ScrawIntent);
            }
        });
        rl_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ScrawIntent = new Intent(getActivity(), SettingActivity.class);
                startActivity(ScrawIntent);
            }
        });

        return root;
    }

    private void click(View view) {
        if(isLogin){
            Navigation.findNavController(view).navigate(R.id.action_navigation_me_to_infoFragment);
        }else{
            Navigation.findNavController(view).navigate(R.id.action_navigation_me_to_loginFragment);
        }
    }
}