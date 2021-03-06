package com.qt.bracelet.component.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import android.content.Context;
import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.qt.bracelet.common.BraceletApp;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.StringResComponent;
import com.qt.bracelet.component.ToastComponent;
import com.qt.bracelet.component.WifiComponent;
import com.qt.bracelet.dialog.MyProcessDialog;
import com.qt.bracelet.domain.Bracelet;
import com.qt.bracelet.domain.User;
import com.qt.bracelet.mapping.UserMapping;

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
	ToastComponent toastComponent;

	@Bean
	StringResComponent stringResComponent;

	@Bean
	WifiComponent wifiComponent;

	@Bean
	ActivityComponent activityComponent;

	@RootContext
	Context context;

	@App
	BraceletApp braceletApp;

	MyProcessDialog dialog;

	/**
	 * 登陆操作
	 * 
	 * @param username
	 * @param password
	 */
	public void executeLogin(String username, String password) {
		dialog = new MyProcessDialog(context, stringResComponent.login_wait);
		new Login().execute(username, password);
	}

	/**
	 * 注销操作
	 * 
	 * @param userId
	 *            用户ID
	 */
	public void executeLogout(String userId) {
		dialog = new MyProcessDialog(context, stringResComponent.login_wait);
		new Logout().execute(userId);
	}

	private Integer loginLocal(String username, String password) {
		if (wifiComponent.isConnected()) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("username", username);
			params.put("password", password);
			return loginRemote(Constants.URL_LOGIN_PATH, params);
		}
		return Constants.STATUS_NETWORK_ERROR;
	}

	private Integer loginRemote(String url, Map<String, String> params) {
		UserMapping data = UserMapping.postJSON(url, params);
		if (data.code == Constants.STATUS_SUCCESS) {
			// 保存本地用户数据
			UserMapping.User remoteUser = data.datas;
			List<UserMapping.Bracelet> bracelets = remoteUser.braceletList;
			User user = User.checkLogin(remoteUser.username);
			if (user == null) {
				user = new User();
				user.uid = remoteUser.id;
				user.username = remoteUser.username;
				user.password = remoteUser.password;
				user.createBy = remoteUser.createBy;
				user.createDate = remoteUser.createDate;
				user.lastLoginDate = remoteUser.lastLoginDate;
				user.modifiedBy = remoteUser.modifiedBy;
				user.modifiedDate = remoteUser.modifiedDate;
				user.realname = remoteUser.realname;
				user.userType = remoteUser.userType;
				user.status = remoteUser.status;
				user.save();
				// 设置本地手环信息
				if (CollectionUtils.isNotEmpty(bracelets)) {
					for (UserMapping.Bracelet item : bracelets) {
						Bracelet bracelet = new Bracelet();
						if (remoteUser.braceletList != null) {
							bracelet.braceletId = item.braceletId;
							bracelet.createBy = item.createBy;
							bracelet.createDate = item.createDate;
							bracelet.modifiedBy = item.modifiedBy;
							bracelet.modifiedDate = item.modifiedDate;
							bracelet.name = item.name;
							bracelet.status = item.status;
							bracelet.type = item.type;
							bracelet.userId = user.uid;
							bracelet.save();
						}
					}
				}

			}
			// 设置APPLICATION全局数据
			setLoginInfo(user);
			activityComponent.startMain();
		}
		return data.code;
	}

	public Integer logout(String userId, String shopId) {
		try {
			User user = new User();
			user.uid = userId;
			return Constants.STATUS_SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Constants.STATUS_FAILED;
	}

	abstract class LoginTaskBasic extends AsyncTask<String, Void, Integer> {
		abstract Integer doExecute(String... objs);

		@Override
		protected Integer doInBackground(String... objs) {
			return doExecute(objs);
		}

		@Override
		protected void onPostExecute(Integer result) {
			dialog.dismiss();
			switch (result) {
			case Constants.STATUS_FAILED:
				toastComponent.show(stringResComponent.login_failed);
				break;
			case Constants.STATUS_SUCCESS:
				toastComponent.show(stringResComponent.login_success);
				break;
			case Constants.STATUS_SERVER_FAILED:
				toastComponent.show(stringResComponent.server_error);
				break;
			case Constants.STATUS_NETWORK_ERROR:
				toastComponent.show(stringResComponent.wifi_error);
				break;
			}
		}

		@Override
		protected void onPreExecute() {
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}

	class Login extends LoginTaskBasic {
		@Override
		Integer doExecute(String... objs) {
			return loginLocal(objs[0], objs[1]);
		}
	}

	class Logout extends LoginTaskBasic {
		@Override
		Integer doExecute(String... objs) {
			return logout(objs[0], objs[1]);
		}
	}

	public void setLoginInfo(User user) {
		braceletApp.setUsername(user.username);
		braceletApp.setUserId(user.uid);
	}

}
