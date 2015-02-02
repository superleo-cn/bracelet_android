package com.qt.bracelet.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.qt.bracelet.activity.BindBraceletActivity_;
import com.qt.bracelet.activity.BloodPressureActivity_;
import com.qt.bracelet.activity.MainActivity_;
import com.qt.bracelet.activity.MotionActivity_;
import com.qt.bracelet.activity.PulseActivity_;
import com.qt.bracelet.activity.SettingActivity_;
import com.qt.bracelet.activity.TemperatureActivity_;
import com.qt.bracelet.dialog.MyProcessDialog;

/** 
* @ClassName: ActivityComponent 
* @Description: Activity跳转处理组件
* @author rw 
* @date 2015-2-2 下午2:26:51 
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
	
	public void startMain(){
		startActivityWithTransaction(MainActivity_.class);
	}
	
	public void startMotion(){
		startActivityWithTransaction(MotionActivity_.class);
	}
	
	public void startSetting(){
		startActivityWithTransaction(SettingActivity_.class);
	}
	
	public void startBloodPressure(){
		startActivityWithTransaction(BloodPressureActivity_.class);
	}
	
	public void startPulse(){
		startActivityWithTransaction(PulseActivity_.class);
	}
	
	public void startTemperature(){
		startActivityWithTransaction(TemperatureActivity_.class);
	}
	
	public void startBind(){
		startActivityWithTransaction(BindBraceletActivity_.class);
	}

	private <T> void startActivityWithTransaction(Class<T> to) {
		startActivity(to);
	}

	public <T> void startActivity(Class<T> cls) {
		Intent intent = new Intent();
		intent.setClass(context, cls);
		activity.startActivity(intent);
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
