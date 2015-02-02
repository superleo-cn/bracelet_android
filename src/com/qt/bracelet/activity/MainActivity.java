package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

	@Bean
	ActivityComponent activityComponent;

	@AfterViews
	public void init() {

	}

	@Click(R.id.setting_tv)
	public void toSetting() {
		activityComponent.startSetting();
	}

	@Click(R.id.motion_tv)
	public void toMotion() {
		activityComponent.startMotion();
	}

	@Click(R.id.pulse_tv)
	public void toPulse() {
		activityComponent.startPulse();
	}

	@Click(R.id.temperature_tv)
	public void toTemperature() {
		activityComponent.startTemperature();
	}

	@Click(R.id.bloodpressure_tv)
	public void toBloodPressure() {
		activityComponent.startBloodPressure();
	}

}
