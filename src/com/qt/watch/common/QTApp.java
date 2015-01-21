package com.qt.watch.common;

import com.activeandroid.app.Application;
import com.googlecode.androidannotations.annotations.EApplication;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.qt.watch.component.SharedPreferencesComponent_;

/** 
* @ClassName: QTApp 
* @Description: QTApplication 
* @author rw 
* @date 2015-1-19 下午2:10:59 
*  
*/ 
@EApplication
public class QTApp extends Application {
	/** 系统初始化配置文件操作器 */
	private String username = "";
	private String userId = "0";
	private String userType = "";
	private String shopName = "";
	private String shopCode = "";
	private boolean superAdmin = false;

	@Pref
	SharedPreferencesComponent_ myPrefs;

	@Override
	public void onCreate() {
		super.onCreate();

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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopId() {
		return myPrefs.shopId().get();
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

}
