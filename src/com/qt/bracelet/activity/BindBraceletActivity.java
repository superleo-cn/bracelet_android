package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.qt.bracelet.R;
import com.qt.bracelet.component.ActivityComponent;

/** 
 * @ClassName: BindBracelet 
 * @Description: 绑定手环处理
 * @author rw 
 * @date 2015-2-2 下午3:12:44 
 *
 */
@EActivity(R.layout.activity_bindbracelet)
public class BindBraceletActivity extends BaseActivity {
	
	@Bean
	ActivityComponent activityComponent;
	
	@Click(R.id.bind_tv)
	public void toMain(){
		activityComponent.startMain();
	}
}
