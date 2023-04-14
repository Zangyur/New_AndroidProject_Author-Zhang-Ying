package com.example.androidqimo234.ui.me.onstellation;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.androidqimo234.R;


public class HeartLayout extends RelativeLayout {
    private AbstractPathAnimator mAnimator;
    public HeartLayout(Context context) {
        super(context);
        init(null, 0);
    }
    public HeartLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public HeartLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }
    private void init(AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.HeartLayout, defStyleAttr, 0);
        mAnimator = new com.example.androidqimo234.ui.me.onstellation.PathAnimator(AbstractPathAnimator.Config.fromTypeArray(a));
        a.recycle();
    }
    public void clearAnimation() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).clearAnimation();
        }
        removeAllViews();
    }
    public void addHeart(int color) {
        com.example.androidqimo234.ui.me.onstellation.HeartView heartView = new com.example.androidqimo234.ui.me.onstellation.HeartView(getContext());
        heartView.setColor(color);
        mAnimator.start(heartView, this);
    }
}
