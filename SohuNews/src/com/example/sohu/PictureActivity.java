package com.example.sohu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PictureActivity extends Activity {
	
	private ViewPager picture_myViewPager;
	private MyPagerAdapter picture_myAdapter;
	private List<View> picture_mListViews;
	private TextView picture_pL0_textView,picture_title_best,picture_title_fun,picture_title_interesting;
	private PageLayout picture_pL0,picture_pL1,pL2;
	private String TAG = "pictureActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture);
		
		picture_title_best = (TextView)findViewById(R.id.picture_title_best);
		picture_title_fun = (TextView)findViewById(R.id.picture_title_fun);
		picture_title_interesting = (TextView)findViewById(R.id.picture_title_interesting);
		picture_myViewPager = (ViewPager) findViewById(R.id.pictureViewPagerLayout);
		picture_myAdapter = new MyPagerAdapter();
		picture_myViewPager.setAdapter(picture_myAdapter);
		picture_mListViews = new ArrayList<View>();

		// <-------------------------生成页面以及页面中的相关组(开始)---------------------------------->
		picture_pL0 = new PageLayout(PictureActivity.this , R.layout.picture_page_layout_0);// 调用layout生成类产生第一个layout页面
		picture_pL0_textView = (TextView)picture_pL0.contentView.findViewById(R.id.pL0_textView);
		picture_pL0_textView.setText("I am Johnason!");
		picture_mListViews.add(picture_pL0); // 将第一个页面加到没ListViews列表中
		
		picture_pL1 = new PageLayout(PictureActivity.this , R.layout.picture_page_layout_1); 
		picture_mListViews.add(picture_pL1);// 将第二个页面加到没ListViews列表中
		
		pL2 = new PageLayout(PictureActivity.this , R.layout.picture_page_layout_2);
		picture_mListViews.add(pL2);// 将第三个页面加到没ListViews列表中
		// <-------------------------生成页面以及页面中的相关组(结束)---------------------------------->
		
		// 初始化当前显示的view
		picture_myViewPager.setCurrentItem(0);
		picture_myViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			// 当新的页面被选中时调用
			@Override
			public void onPageSelected(int arg0) {
				Log.d(TAG, "onPageSelected - " + arg0);
				@SuppressWarnings("unused")
				View v = picture_mListViews.get(arg0);
				changeBottomItemBackground(arg0);
			}

			// 当当前页面被滑动时调用
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				Log.d(TAG, "onPageScrolled - " + arg0);
				// 从1到2滑动，在1滑动前调用
			}

			// 当滑动状态改变时调用
			@Override
			public void onPageScrollStateChanged(int arg0) {
				Log.d(TAG, "onPageScrollStateChanged - " + arg0);
			}
		});
		//设置顶部选项点击事件
		picture_title_best.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				picture_myViewPager.setCurrentItem(0);
				changeBottomItemBackground(0);
			}
		});
		picture_title_fun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				picture_myViewPager.setCurrentItem(1);
				changeBottomItemBackground(1);
			}
		});
		picture_title_interesting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				picture_myViewPager.setCurrentItem(2);
				changeBottomItemBackground(2);
			}
		});
	}
	private class MyPagerAdapter extends PagerAdapter {
		// 销毁arg1位置的界面
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(picture_mListViews.get(arg1));
		}

		// 获取当前窗体界面数
		@Override
		public int getCount() {
			return picture_mListViews.size();
		}

		// 初始化arg0位置的界面
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			Log.d(TAG, "instantiateItem");
			((ViewPager) arg0).addView(picture_mListViews.get(arg1), 0);
			return picture_mListViews.get(arg1);
		}

		// 判断是否由对象生成界面
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			Log.d(TAG, "isViewFromObject");
			return arg0 == (arg1);
		}
	}
	
	public void changeBottomItemBackground(int i){
		switch(i){
		case 0:
			picture_title_best.setBackgroundColor(Color.parseColor("#FFFFFF"));
			picture_title_fun.setBackgroundColor(Color.parseColor("#CCCCCC"));
			picture_title_interesting.setBackgroundColor(Color.parseColor("#CCCCCC"));
			break;
		case 1:
			picture_title_best.setBackgroundColor(Color.parseColor("#CCCCCC"));
			picture_title_fun.setBackgroundColor(Color.parseColor("#FFFFFF"));
			picture_title_interesting.setBackgroundColor(Color.parseColor("#CCCCCC"));
			break;
		case 2:
			picture_title_best.setBackgroundColor(Color.parseColor("#CCCCCC"));
			picture_title_fun.setBackgroundColor(Color.parseColor("#CCCCCC"));
			picture_title_interesting.setBackgroundColor(Color.parseColor("#FFFFFF"));
			break;
		}	
	}
}
