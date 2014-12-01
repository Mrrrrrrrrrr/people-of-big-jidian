package com.example.sohu;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {
	
	private ImageView imageView_enter;
	private Timer timer = new Timer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		imageView_enter = (ImageView)findViewById(R.id.welcome_page_enter_image);
		imageView_enter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(WelcomeActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
		timer.schedule(task, 4000); 
	}
	
	Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				Intent intent = new Intent();
				intent.setClass(WelcomeActivity.this, MainActivity.class);
				startActivity(intent);
				break;			
			}
			super.handleMessage(msg);
		}

	};
	
	TimerTask task = new TimerTask() {

		public void run() {
			Message message = new Message();
			message.what = 1;
			handler.sendMessage(message);
		}

	};
}
