package com.example.androidqimo234.ui.home.web;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.androidqimo234.MainActivity;
import com.example.androidqimo234.R;
import com.example.androidqimo234.base.BaseFragment2;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;

public class WebFragment extends BaseFragment2 {

    private AgentWeb mAgentWeb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View root= inflater.inflate(R.layout.fragment_web, container, false);
        mAgentWeb=AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) root,new ViewGroup.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT))

            .useDefaultIndicator()
                .setWebChromeClient(new WebChromeClient(){
                    //设置网页的跳转的不同标题也不同
                    @Override
                    public void onReceivedTitle(WebView view, String title) {
                        super.onReceivedTitle(view, title);
                       MainActivity activity= (MainActivity) getActivity();
                        if (activity != null) {
                            ActionBar supportActionBar= activity.getSupportActionBar();
                            if (supportActionBar != null) {
                                supportActionBar.setTitle(title);
                            }
                        }
                    }
                })
            .createAgentWeb()
            .ready()
            .go(getArguments() != null ? getArguments().getString("url")
                    : "http://www.jd.com");
        return root;
    }
    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }
    @Override
    public void onDestroyView() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroyView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mAgentWeb.handleKeyEvent(keyCode,event);
    }
}