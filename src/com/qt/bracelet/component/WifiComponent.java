package com.qt.bracelet.component;

import java.net.SocketException;

import android.content.Context;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;
import com.qt.bracelet.common.SystemHelper;

/**
 * 更新组件
 * 
 * @author superleo
 * 
 */
@EBean(scope = Scope.Singleton)
public class WifiComponent {

	@RootContext
	Context context;

	public String getIPAddress() {
		try {
			return SystemHelper.getLocalIPAddress() == null ? "0" : SystemHelper.getLocalIPAddress();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return "0";
	}

	public String getMacAddress(Context context) {
		return SystemHelper.getLocalMacAddress(context) == null ? "0" : SystemHelper.getLocalMacAddress(context);
	}

	public boolean isConnected() {
		return SystemHelper.isConnected(context);
	}

}
