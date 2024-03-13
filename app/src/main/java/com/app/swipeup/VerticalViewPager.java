package com.app.swipeup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class VerticalViewPager extends ViewPager {
    public VerticalViewPager(@NonNull Context context) {
        super(context);
    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setPageTransformer(true,new verticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class verticalPageTransformer implements ViewPager.PageTransformer{

        @Override
        public void transformPage(@NonNull View page, float position) {
            if (position<-1){
                page.setAlpha(0);
            }else if (position<=0){
                page.setAlpha(1);
                page.setTranslationX(page.getWidth() * -position);

                float yposition =position * page.getHeight();
                page.setTranslationY(yposition);

                page.setScaleX(1);
                page.setScaleY(1);

            }else  if (position<=1){
                page.setTranslationX(page.getWidth() *-position);

                float scale=0.75f + (1-0.75f) * (1-Math.abs(position));
                page.setScaleX(scale);
                page.setScaleY(scale);
            }else {
                page.setAlpha(0);
            }

        }
    }

    private MotionEvent swapXYcordinates(MotionEvent event){

        float width=getWidth();
        float hight=getHeight();

        float newx=(event.getY() / hight) * width;
        float newy=(event.getX() / width)*hight;

        event.setLocation(newx,newy);
        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted=super.onInterceptTouchEvent(swapXYcordinates(ev));
        swapXYcordinates(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXYcordinates(ev));
    }
}
