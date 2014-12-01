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

public class NewsActivity extends Activity {
	
	private ViewPager news_myViewPager;
	private MyPagerAdapter news_myAdapter;
	private List<View> news_mListViews;
	private TextView news_pL0_textView,news_title_important,news_title_fun,news_title_sports;
	private PageLayout news_pL0,news_pL1,news_pL2;
	private String TAG = "newsActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		
		news_title_important = (TextView)findViewById(R.id.news_title_important);
		news_title_fun = (TextView)findViewById(R.id.news_title_fun);
		news_title_sports = (TextView)findViewById(R.id.news_title_sports);
		news_myViewPager = (ViewPager) findViewById(R.id.newsViewPagerLayout);
		news_myAdapter = new MyPagerAdapter();
		news_myViewPager.setAdapter(news_myAdapter);
		news_mListViews = new ArrayList<View>();

		// <-------------------------生成页面以及页面中的相关组(开始)---------------------------------->
		news_pL0 = new PageLayout(NewsActivity.this , R.layout.news_page_layout_0);// 调用layout生成类产生第一个layout页面
		news_pL0_textView = (TextView)news_pL0.contentView.findViewById(R.id.pL0_textView);
		news_pL0_textView.setText("I am Johnason!");
		news_mListViews.add(news_pL0); // 将第一个页面加到没ListViews列表中
		
		news_pL1 = new PageLayout(NewsActivity.this , R.layout.news_page_layout_1); 
		news_mListViews.add(news_pL1);// 将第二个页面加到没ListViews列表中
		
		news_pL2 = new PageLayout(NewsActivity.this , R.layout.news_page_layout_2);
		news_mListViews.add(news_pL2);// 将第三个页面加到没ListViews列表中
		// <-------------------------生成页面以及页面中的相关组(结束)---------------------------------->
		
		// 初始化当前显示的view
		news_myViewPager.setCurrentItem(0);
		news_myViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			// 当新的页面被选中时调用
			@Override
			public void onPageSelected(int arg0) {
				Log.d(TAG, "onPageSelected - " + arg0);
				@SuppressWarnings("unused")
				View v = news_mListViews.get(arg0);
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
		news_title_important.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				news_myViewPager.setCurrentItem(0);
				changeBottomItemBackground(0);
			}
		});
		news_title_fun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				news_myViewPager.setCurrentItem(1);
				changeBottomItemBackground(1);
			}
		});
		news_title_sports.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				news_myViewPager.setCurrentItem(2);
				changeBottomItemBackground(2);
			}
		});
	}
	private class MyPagerAdapter extends PagerAdapter {
		// 销毁arg1位置的界面
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(news_mListViews.get(arg1));
		}

		// 获取当前窗体界面数
		@Override
		public int getCount() {
			return news_mListViews.size();
		}

		// 初始化arg0位置的界面
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			Log.d(TAG, "instantiateItem");
			((ViewPager) arg0).addView(news_mListViews.get(arg1), 0);
			return news_mListViews.get(arg1);
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
			news_title_important.setBackgroundColor(Color.parseColor("#FFFFFF"));
			news_title_fun.setBackgroundColor(Color.parseColor("#CCCCCC"));
			news_title_sports.setBackgroundColor(Color.parseColor("#CCCCCC"));
			break;
		case 1:
			news_title_important.setBackgroundColor(Color.parseColor("#CCCCCC"));
			news_title_fun.setBackgroundColor(Color.parseColor("#FFFFFF"));
			news_title_sports.setBackgroundColor(Color.parseColor("#CCCCCC"));
			break;
		case 2:
			news_title_important.setBackgroundColor(Color.parseColor("#CCCCCC"));
			news_title_fun.setBackgroundColor(Color.parseColor("#CCCCCC"));
			news_title_sports.setBackgroundColor(Color.parseColor("#FFFFFF"));
			break;
		}	
	}
}
