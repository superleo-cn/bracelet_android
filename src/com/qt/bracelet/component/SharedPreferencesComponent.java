package com.qt.bracelet.component;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultLong;
import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultString;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

/** 
* @ClassName: SharedPreferencesComponent 
* @Description: 用接口代替直接使用变量, 方便安全 
* @author rw 
* @date 2015-1-27 上午10:03:00 
*
*/ 
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface SharedPreferencesComponent {

	// 如果没有值的话，设置一个默认值 "zh"
	@DefaultString("zh")
	String language();

	@DefaultLong(1)
	long time();
	
}