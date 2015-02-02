package com.qt.bracelet.component.ui;

import android.app.Activity;
import android.content.Context;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/** 
 * @ClassName: TemperatureComponent 
 * @Description: 温度处理组件 
 * @author rw 
 * @date 2015-2-2 下午2:22:42 
 *
 */
@EBean
public class TemperatureComponent {
	
	@RootContext
	Context context;
	
	@RootContext
	Activity activity;

}
