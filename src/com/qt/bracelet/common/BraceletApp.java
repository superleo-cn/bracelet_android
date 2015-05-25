package com.qt.bracelet.common;

import cn.jpush.android.api.JPushInterface;
import com.activeandroid.app.Application;
import com.googlecode.androidannotations.annotations.EApplication;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.qt.bracelet.component.SharedPreferencesComponent_;

/** 
* @ClassName: BraceletApp 
* @Description: QTApplication 
* @author rw 
* @date 2015-1-19 下午2:10:59 
*  
*/ 
@EApplication
public class BraceletApp extends Application {
	private static final String TAG = "JPush";

	/** 系统初始化配置文件操作器 */
	private String username = "";
	private String userId = "0";
	private String userType = "";

	@Pref
	SharedPreferencesComponent_ myPrefs;

	@Override
	public void onCreate() {
		super.onCreate();

		JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
		JPushInterface.init(this);     		// 初始化 JPush

	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
