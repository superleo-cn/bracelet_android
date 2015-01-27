package com.qt.bracelet.activity;

import android.content.Intent;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ObtainVitalSignsComponent;
import com.qt.bracelet.domain.VitalSignsData;
import com.qt.bracelet.server.ObtainVitalSignsServer_;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
	@Bean
	ObtainVitalSignsComponent ovsComponent;
	
	@AfterViews
	public void init(){
		ovsComponent.executeObtainData();
//		if (VitalSignsData.queryAllList().size() <= 0){
//			startService(new Intent(this, ObtainVitalSignsServer_.class));
//		}
	}

}
