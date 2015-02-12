package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ui.ObtainVitalSignsComponent;

/** 
 * @ClassName: BindBracelet 
 * @Description: 获取绑定手环数据处理
 * @author rw 
 * @date 2015-2-2 下午3:12:44 
 *
 */
@EActivity(R.layout.activity_bindbracelet)
public class BindBraceletActivity extends BaseActivity {
	
	@Bean
	ObtainVitalSignsComponent obtainVitalSignsComponent;
	
	@AfterViews
	public void init(){
		obtainVitalSignsComponent.executeObtainData();
	}
	
}
