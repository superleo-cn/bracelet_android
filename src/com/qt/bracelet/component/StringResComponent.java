package com.qt.bracelet.component;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.res.StringRes;
import com.qt.bracelet.R;

/** 
* @ClassName: StringResComponent 
* @Description: 字符串注入组件
* @author rw 
* @date 2015-1-17 下午3:26:02 
*  
*/ 
@EBean
public class StringResComponent {

	@StringRes(R.string.load_wait)
	public String load_wait;
	
	@StringRes(R.string.login_failed)
	public String login_failed;
	
	@StringRes(R.string.login_success)
	public String login_success;
	
	@StringRes(R.string.wifi_error)
	public String wifi_error;
	
	@StringRes(R.string.server_error)
	public String server_error;
	
	@StringRes(R.string.load_wait)
	public String login_wait;
	
	@StringRes(R.string.update_wait)
	public String update_wait;
	
	@StringRes(R.string.update_success)
	public String update_success;
	
	@StringRes(R.string.update_failed)
	public String update_failed;
	
	@StringRes(R.string.login_nameorpas_notempty)
	public String login_nameorpas_notempty;
	

}
