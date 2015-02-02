package com.qt.bracelet.component.ui;

import android.app.Activity;
import android.content.Context;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/** 
 * @ClassName: PulseComponent 
 * @Description: 脉搏处理组件
 * @author rw 
 * @date 2015-2-2 下午2:23:23 
 *
 */
@EBean
public class PulseComponent {
	
	@RootContext
	Context context;
	
	@RootContext
	Activity activity;

}
