package com.app.swipeup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<SliderItems> sliderItems=new ArrayList<>();
//    VerticalViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VerticalViewPager verticalViewPager =(VerticalViewPager) findViewById(R.id.viewpager);

        sliderItems.add(new SliderItems(R.drawable.ic_launcher_background));
        sliderItems.add(new SliderItems(R.drawable.ic_launcher_background));
        sliderItems.add(new SliderItems(R.drawable.ic_launcher_background));

        verticalViewPager.setAdapter(new ViewPagerAdapter(MainActivity.this,sliderItems));

    }
}