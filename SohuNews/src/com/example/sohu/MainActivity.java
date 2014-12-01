package com.example.sohu;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements OnClickListener {
	TabHost mTabHost;
	RadioButton rb_tab1, rb_tab2, rb_tab3, rb_tab4;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);// 设置没有标题
		getWindow().setFormat(PixelFormat.TRANSPARENT);// 窗口支持透明
		getWindow().getDecorView().setBackgroundDrawable(null);// 设置顶级的窗口背景为null
		setContentView(R.layout.activity_main);
		init();

		this.mTabHost.addTab(this.mTabHost.newTabSpec("tab1")
				.setIndicator("tab1").setContent(new Intent(this, HomeActivity.class)));
		this.mTabHost.addTab(this.mTabHost.newTabSpec("tab2")
				.setIndicator("tab2").setContent(new Intent(this, NewsActivity.class)));
		this.mTabHost.addTab(this.mTabHost.newTabSpec("tab3")
				.setIndicator("tab3").setContent(new Intent(this, PictureActivity.class)));
		this.mTabHost.addTab(this.mTabHost.newTabSpec("tab4")
				.setIndicator("tab4").setContent(new Intent(this, MoreActivity.class)));

		rb_tab1.setOnClickListener(this);
		rb_tab2.setOnClickListener(this);
		rb_tab3.setOnClickListener(this);
		rb_tab4.setOnClickListener(this);
	}

	public void init() {
		this.mTabHost = getTabHost();
		rb_tab1 = (RadioButton) findViewById(R.id.rb_tab1);
		rb_tab2 = (RadioButton) findViewById(R.id.rb_tab2);
		rb_tab3 = (RadioButton) findViewById(R.id.rb_tab3);
		rb_tab4 = (RadioButton) findViewById(R.id.rb_tab4);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rb_tab1:
			rb_tab1.setChecked(true);
			rb_tab2.setChecked(false);
			rb_tab3.setChecked(false);
			rb_tab4.setChecked(false);
			mTabHost.setCurrentTab(0);
			break;
		case R.id.rb_tab2:
			rb_tab1.setChecked(false);
			rb_tab2.setChecked(true);
			rb_tab3.setChecked(false);
			rb_tab4.setChecked(false);
			mTabHost.setCurrentTab(1);
			break;
		case R.id.rb_tab3:
			rb_tab1.setChecked(false);
			rb_tab2.setChecked(false);
			rb_tab3.setChecked(true);
			rb_tab4.setChecked(false);
			mTabHost.setCurrentTab(2);
			break;
		case R.id.rb_tab4:
			rb_tab1.setChecked(false);
			rb_tab2.setChecked(false);
			rb_tab3.setChecked(false);
			rb_tab4.setChecked(true);
			mTabHost.setCurrentTab(3);
			break;
		}
	}
}