package com.example.sohu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public class PageLayout extends RelativeLayout {
	private LayoutInflater mInflater;
	private int mlayout;
	public View contentView;
	// 页面生成器
	public PageLayout(Context context , int layout) {
		super(context);
		this.mInflater = LayoutInflater.from(context);
		this.mlayout = layout;
		initLayout(context);
	}

	public void initLayout(Context context) {
		contentView = mInflater.inflate(mlayout, null);
		LayoutParams relativeParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		this.addView(contentView,relativeParams);
	}
}