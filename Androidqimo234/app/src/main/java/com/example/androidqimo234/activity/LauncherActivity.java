package com.example.androidqimo234.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            SharedPreferences sharedPreferences = getSharedPreferences("setting",
                    MODE_PRIVATE);
            boolean isFirst = sharedPreferences.getBoolean("isFirst", true);
            if (isFirst) {
                startActivity(new Intent(LauncherActivity.this,
                        IntroActivity.class));
                sharedPreferences.edit().putBoolean("isFirst", false).apply();
            } else {
                startActivity(new Intent(LauncherActivity.this,
                        SplashActivity.class));
            }
            finish();
        }, 1000);
        Glide.with(this).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fassets.pushthink.com%2Fuploads%2Fphoto%2Fimage%2F419976%2Fcc9673df8f0d60d3d5825a5e4de3d823.gif&refer=http%3A%2F%2Fassets.pushthink.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1643252158&t=6e3384dcb10260d9c80ad74dcdcfac53").preload();
    }
}
