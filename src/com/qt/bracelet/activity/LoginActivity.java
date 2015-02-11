package com.qt.bracelet.activity;

import org.apache.commons.lang.StringUtils;

import android.widget.EditText;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.ui.LoginComponent;

/**
 * @ClassName: LoginActivity
 * @Description: 登陆
 * @author rw
 * @date 2015-1-28 上午11:39:17
 * 
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

	@Bean
	ActivityComponent activityComponent;

	@Bean
	LoginComponent loginComponent;
	
	@ViewById(R.id.login_username_et)
	EditText login_username_et;
	
	@ViewById(R.id.login_password_et)
	EditText login_password_et;

	@AfterViews
	public void init() {
		
	}

	@Click(R.id.login_btn)
	public void login() {
		String username = StringUtils.trim(login_username_et.getText().toString());
		String password = StringUtils.trim(login_password_et.getText().toString());
		loginComponent.executeLogin(username, password);
		return;
	}

}
