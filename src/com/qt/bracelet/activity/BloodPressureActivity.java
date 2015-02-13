package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.widget.PathView;

/** 
 * @ClassName: BloodPressureActivity 
 * @Description: 血压相关 
 * @author rw 
 * @date 2015-2-2 下午2:19:41 
 *
 */
@EActivity(R.layout.activity_bloodpressure)
public class BloodPressureActivity extends BaseActivity {
	
	@ViewById(R.id.bloodpressure_pv)
	PathView bloodpressure_pv;
	
	@AfterViews
	public void init() {
		bloodpressure_pv.setXCount(160,20);
		bloodpressure_pv.setType(PathView.MONTH_YEAR);
		bloodpressure_pv.setDate(new int[]{80,98,120,119,116,115,116,100,101,99,135,126});
	}
	
	@Click(R.id.back_iv)
	public void back(){
		this.finish();
	}

}
