package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.bracelet.R;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.ui.MainComponent;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

	@Bean
	MainComponent mainComponent;

	@Bean
	ActivityComponent activityComponent;

	@AfterViews
	public void init() {
		mainComponent.requestData();
	}

	@Click(R.id.setting_iv)
	public void toSetting() {
		activityComponent.startSetting();
	}
}
