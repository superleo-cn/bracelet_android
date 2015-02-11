package com.qt.bracelet.component;

import android.content.Context;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;

/** 
* @ClassName: ToastComponent 
* @Description: 消息提示组件
* @author rw 
* @date 2015-2-11 下午7:45:41 
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
