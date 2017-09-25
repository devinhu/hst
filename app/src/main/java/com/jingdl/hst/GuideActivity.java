/*
    ShengDao Android Client, GuideActivity
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.jingdl.hst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * [新手指引页面]
 *
 * @author devin.hu
 * @version 1.0
 * @date 2014-2-7
 **/
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener{

    private ViewPager guidePages;
    private ArrayList<View> pageViews;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_guide);
        PreferencesManager.getInstance(this).put("IS_FIRST_RUN", false);

        LayoutInflater inflater = getLayoutInflater();
        pageViews = new ArrayList<View>();
        pageViews.add(inflater.inflate(R.layout.layout_guide_item1, null));
        pageViews.add(inflater.inflate(R.layout.layout_guide_item2, null));
        pageViews.add(inflater.inflate(R.layout.layout_guide_item3, null));
        pageViews.add(inflater.inflate(R.layout.layout_guide_item4, null));

        guidePages = (ViewPager) findViewById(R.id.guidePages);
        for (int i = 0; i < pageViews.size(); i++) {
            imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
            imageView.setPadding(20, 0, 20, 0);
        }

        guidePages.setAdapter(new ViewPagerAdapter(pageViews));
        guidePages.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        //点击最后一页，跳转到主页
        if(position == 3){
            View itemView = pageViews.get(position);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
