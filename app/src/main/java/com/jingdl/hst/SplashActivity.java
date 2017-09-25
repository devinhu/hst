/*
    ShengDao Android Client, SplashActivity
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.jingdl.hst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;


/**
 * [预加载页面]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class SplashActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) == Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) {
		    super.onCreate(savedInstanceState);
			finish();
			return;
		}
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_splash);
		ImageView imglogo = (ImageView) findViewById(R.id.imglogo);

		// 渐变展示启动屏
		AlphaAnimation aa = new AlphaAnimation(0.1f, 1.0f);
		aa.setDuration(2000);
		imglogo.startAnimation(aa);
		aa.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {
				intoMainPage();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationStart(Animation animation) {

			}

		});
	}
	
	public void intoMainPage(){
		boolean isFirstRun = PreferencesManager.getInstance(this).get("IS_FIRST_RUN", true);
		if(isFirstRun){
			Intent intent = new Intent(this, GuideActivity.class);
			startActivity(intent);
			finish();
		}else{
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
}
