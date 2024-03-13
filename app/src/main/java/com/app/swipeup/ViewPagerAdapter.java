package com.app.swipeup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {


    List<SliderItems> sliderItems;
    LayoutInflater mlayout;
    Context context;

    public ViewPagerAdapter(Context context, List<SliderItems> sliderItems) {
        this.sliderItems = sliderItems;
        this.context=context;
        mlayout=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sliderItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemview=mlayout.inflate(R.layout.swipe,container, false);
        ImageView imageView=itemview.findViewById(R.id.imageaa);
        imageView.setImageResource(sliderItems.get(position).getImage());

        container.addView(itemview);
        return  itemview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
