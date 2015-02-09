package com.qt.bracelet.server;

import java.util.Timer;
import java.util.TimerTask;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EService;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.qt.bracelet.component.SharedPreferencesComponent_;
import com.qt.bracelet.component.ToastComponent;
import com.qt.bracelet.component.WifiComponent;
import com.qt.bracelet.component.ui.ObtainVitalSignsComponent;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

/** 
 * @ClassName: ObtainVitalSignsServer 
 * @Description: 获取生命体征数据服务 
 * @author rw 
 * @date 2015-1-22 下午10:36:03 
 *  
 */
@EService
public class ObtainVitalSignsServer extends Service {
	
	@Bean
	WifiComponent wifiComponent;
	
	@Pref
	SharedPreferencesComponent_ myPrefs;
	
	@Bean
	ObtainVitalSignsComponent obtainVialSignsComponent;
	
	@Bean
	ToastComponent toastComponent;
	
	// 获取数据timer
	private Timer obtainTimer;
	
	// 清除数据timer
	private Timer clearTimer;
	
	private Handler handler = new Handler();

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		if (obtainTimer != null) {
			obtainTimer.cancel();
		} else {
			obtainTimer = new Timer();
		}
		
		// 每隔十分钟执行一次
		final long time = myPrefs.time().get() * 60 * 1000;
		obtainTimer.scheduleAtFixedRate(new ObtainTimer(), 60 * 1000, time);
		
		if (clearTimer != null) {
			clearTimer.cancel();
		} else {
			clearTimer = new Timer();
		}
		
		// 每隔十天执行一次
		final long clearTime = 10 * 24 * 60 * 60 * 1000;
		clearTimer.scheduleAtFixedRate(new ClearTimer(), 60 * 1000, clearTime);
	}
	
	// 获取数据时间任务
	class ObtainTimer extends TimerTask {

		@Override
		public void run() {
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					if (wifiComponent.isConnected()) {
						try {
							obtainVialSignsComponent.executeObtainData();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					} else {
						 toastComponent.show("数据同步异常");
					}
				}
			});
		}
		
	}
	
	// 获取数据时间任务
	class ClearTimer extends TimerTask {

		@Override
		public void run() {
			handler.post(new Runnable() {

				@Override
				public void run() {
					// display toast
//					cleanHistorySchedularComponent.cleanHistory();
				}

			});
		}
		
	}		

}
