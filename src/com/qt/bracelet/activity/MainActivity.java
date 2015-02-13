package com.qt.bracelet.activity;

import android.view.View;
import android.widget.ImageView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.widget.PathView;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

	@Bean
	ActivityComponent activityComponent;
	
	@ViewById(R.id.pv)
	PathView pv;
	
	@ViewById(R.id.back_iv)
	ImageView back_iv;
	
	@ViewById(R.id.setting_iv)
	ImageView setting_iv;

	@AfterViews
	public void init() {
		back_iv.setVisibility(View.GONE);
		setting_iv.setVisibility(View.VISIBLE);
		pv.setXCount(200, 20);
		pv.setType(PathView.MONTH_YEAR);
		pv.setDate(new int[]{80,98,120,119,116,115,116,115,101,99,115,106});

	}

	@Click(R.id.setting_iv)
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
