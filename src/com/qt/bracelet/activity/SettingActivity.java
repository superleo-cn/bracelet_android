package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.bracelet.R;

/** 
 * @ClassName: SettingActivity 
 * @Description: 设置A 
 * @author rw 
 * @date 2015-2-2 下午2:41:36 
 *
 */
@EActivity(R.layout.activity_setting)
public class SettingActivity extends BaseActivity {
	
	@Click(R.id.back_iv)
	public void back(){
		this.finish();
	}

}
