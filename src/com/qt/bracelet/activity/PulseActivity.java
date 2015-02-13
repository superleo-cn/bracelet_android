package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.widget.PathView;

/** 
 * @ClassName: PulseActivity 
 * @Description: 脉搏相关 
 * @author rw 
 * @date 2015-2-2 下午2:18:51 
 *
 */
@EActivity(R.layout.activity_pulse)
public class PulseActivity extends BaseActivity {
	
	@ViewById(R.id.pulse_pv)
	PathView pulse_pv;
	
	@AfterViews
	public void init() {
		pulse_pv.setXCount(140,14);
		pulse_pv.setType(PathView.MONTH_YEAR);
		pulse_pv.setDate(new int[]{80,98,120,119,116,115,116,115,101,99,115,106});

	}
	
	@Click(R.id.back_iv)
	public void back(){
		this.finish();
	}

}
