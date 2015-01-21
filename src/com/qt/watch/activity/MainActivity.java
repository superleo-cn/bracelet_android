package com.qt.watch.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.watch.R;
import com.qt.watch.component.ObtainVitalSignsComponent;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
	
	@Bean
	ObtainVitalSignsComponent obtainVitalSignsComponent;
	
	@AfterViews
	public void init(){
		obtainVitalSignsComponent.executeObtainData();
	}

}
