package com.example.mobileutskevindinata;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

public class FadePageTransformer implements ViewPager2.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {
            // Page is not visible
            page.setAlpha(0);
        } else if (position <= 0) {
            // Fade in
            page.setAlpha(1 + position);
        } else {
            // Fade out
            page.setAlpha(1 - position);
        }
    }
}
