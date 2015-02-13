package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.widget.PathView;

/** 
 * @ClassName: TemperatureActivity 
 * @Description: 体温数据相关 
 * @author rw 
 * @date 2015-2-2 下午2:17:18 
 *
 */
@EActivity(R.layout.activity_temperature)
public class TemperatureActivity extends BaseActivity {
	
	@ViewById(R.id.temperature_pv)
	PathView temperature_pv;
	
	@AfterViews
	public void init() {
		temperature_pv.setXCount(50, 5);
		temperature_pv.setType(PathView.MONTH_YEAR);
		temperature_pv.setDate(new int[]{36,37,35,37,37,36,35,35,36,35,37,36});

	}
	
	@Click(R.id.back_iv)
	public void back(){
		this.finish();
	}

}
