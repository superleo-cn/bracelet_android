package com.qt.watch.component;

import android.content.Context;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;

/**
 * 更新组件
 * 
 * @author superleo
 * 
 */
@EBean(scope = Scope.Singleton)
public class ToastComponent {

	@RootContext
	Context context;

	public void show(String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	public void showLong(String message) {
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

}
