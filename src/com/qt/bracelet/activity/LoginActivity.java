package com.qt.bracelet.activity;

import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.ObtainVitalSignsComponent;

/** 
 * @ClassName: LoginActivity 
 * @Description: 登陆 
 * @author rw 
 * @date 2015-1-28 上午11:39:17 
 *
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
	
	@ViewById(R.id.login_tv)
	TextView login_tv;
	
	@Bean
	ActivityComponent activityComponent;
		
	@Bean
	ObtainVitalSignsComponent ovsComponent;
	
	@AfterViews
	public void init(){
//		ovsComponent.executeObtainData();
//		if (VitalSignsData.queryAllList().size() <= 0){
//			startService(new Intent(this, ObtainVitalSignsServer_.class));
//		}
	}
	
	@Click(R.id.login_tv)
	public void toMain(){
		activityComponent.startBind();
	}

}

