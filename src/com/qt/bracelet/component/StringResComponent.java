package com.qt.bracelet.component;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.res.StringRes;
import com.qt.watch.R;

/** 
* @ClassName: StringResComponent 
* @Description: 字符串注入组件
* @author rw 
* @date 2015-1-17 下午3:26:02 
*  
*/ 
@EBean
public class StringResComponent {

	@StringRes(R.string.load_wait)
	public String load_wait;

}
