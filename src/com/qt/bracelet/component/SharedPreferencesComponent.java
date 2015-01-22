package com.qt.bracelet.component;


import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultLong;
import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultString;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

// 用接口代替直接使用变量, 方便安全
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface SharedPreferencesComponent {

	// 如果没有值的话，设置一个默认值 "zh"
	@DefaultString("zh")
	String language();

	@DefaultString("0.9")
	String discount();

	@DefaultString("0.2")
	String packageCost();

	@DefaultString("")
	String printIp();

	@DefaultString("0")
	String shopId();

	@DefaultLong(30)
	long time();
	
	@DefaultString("")
	String shopName();
		
	@DefaultString("")
	String shopAddress();
	
	@DefaultString("")
	String shopContact();
	
	@DefaultString("")
	String shopWebsite();
	
	@DefaultString("")
	String shopEmail();
	
	@DefaultString("")
	public String openTime();
	
	@DefaultString("")
	public String gstRegNo();
	
	@DefaultString("")
	public String gstRate();
	
	@DefaultString("")
	public String serviceRate();
	
	@DefaultString("")
	public String weChat();
	
	@DefaultBoolean(false)
	public boolean kichenPrinter();
}