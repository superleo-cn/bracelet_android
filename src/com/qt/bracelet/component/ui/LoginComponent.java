package com.qt.bracelet.component.ui;

import android.content.Context;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;

/** 
 * @ClassName: LoginComponent 
 * @Description: 登录组件 
 * @author rw 
 * @date 2015-2-9 下午9:40:12 
 *  
 */
@EBean
public class LoginComponent {
	
	@Bean
	ActivityComponent activityComponent;
	
	@RootContext
	Context context;	

}
