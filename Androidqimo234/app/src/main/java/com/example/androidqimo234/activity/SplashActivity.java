package com.example.androidqimo234.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.androidqimo234.MainActivity;
import com.example.androidqimo234.R;

public class SplashActivity extends AppCompatActivity {
    private boolean isClick;
    private boolean isBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fassets.pushthink.com%2Fuploads%2Fphoto%2Fimage%2F419976%2Fcc9673df8f0d60d3d5825a5e4de3d823.gif&refer=http%3A%2F%2Fassets.pushthink.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1643252158&t=6e3384dcb10260d9c80ad74dcdcfac53").into(imageView);
        new Handler().postDelayed(() -> {
            if (!isClick && !isBack) {
                startActivity(new Intent(SplashActivity.this,
                        MainActivity.class));
                finish();
            }
        }, 5000);
    }

    public void skip(View view) {
        isClick = true;
        startActivity(new Intent(SplashActivity.this,
                MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isBack = true;
    }
}

