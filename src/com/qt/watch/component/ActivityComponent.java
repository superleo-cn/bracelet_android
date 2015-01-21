package com.qt.watch.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.qt.watch.dialog.MyProcessDialog;

/**
 * 更新组件，因为要调用activey类，所以没法做成Singleton
 * 
 * @author superleo
 * 
 */
@EBean
public class ActivityComponent {

	@Bean
	StringResComponent stringResComponent;

	// 注入 Context 变量
	@RootContext
	Context context;

	// 注入 Activity 变量
	@RootContext
	Activity activity;

	MyProcessDialog dialog;

	private <T> void startActivityWithTransaction(Class<T> to) {
		startActivity(to);
	}

	public <T> void startActivity(Class<T> cls) {
		Intent intent = new Intent();
		intent.setClass(context, cls);
		activity.startActivity(intent);
		activity.finish();
	}

	class SwitchActivity extends AsyncTask<Class, Void, Integer> {

		@Override
		protected Integer doInBackground(Class... cls) {
			startActivity(cls[0]);
			return Integer.MIN_VALUE;
		}

		@Override
		protected void onPostExecute(Integer result) {
			dialog.dismiss();
		}

		@Override
		protected void onPreExecute() {
			dialog = new MyProcessDialog(context, stringResComponent.load_wait);
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}

}
