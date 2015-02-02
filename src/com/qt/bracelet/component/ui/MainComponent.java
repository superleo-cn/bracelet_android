package com.qt.bracelet.component.ui;

import android.app.Activity;
import android.content.Context;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/** 
 * @ClassName: MainComponent 
 * @Description: 主页组件
 * @author rw 
 * @date 2015-2-2 下午2:46:06 
 *
 */
@EBean
public class MainComponent {
	
	@RootContext
	Context context;
	
	@RootContext
	Activity activity;

}
