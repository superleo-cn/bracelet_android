package com.qt.bracelet.component;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.qt.bracelet.server.ObtainVitalSignsServer;

/** 
 * @ClassName: SchedularComponent 
 * @Description: 自动同步数据组件 
 * @author rw 
 * @date 2015-1-27 上午10:03:50 
 *
 */
@EBean
public class SchedularComponent {
	
	@RootContext
	Context context;
	
	@Pref
	SharedPreferencesComponent_ myPrefs;
	
	protected void onStart(Activity cls) {
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Service.ALARM_SERVICE);
		
		Intent intent = new Intent(cls, ObtainVitalSignsServer.class);
		final PendingIntent pi = PendingIntent.getService(cls, 0, intent, 0);
		// 设置每10分钟执行pi代表的组件一次
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 0, myPrefs.time().get(), pi);
		
	}

}
