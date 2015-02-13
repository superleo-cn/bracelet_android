package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qt.bracelet.R;
import com.qt.bracelet.widget.PathView;

/** 
 * @ClassName: MotionActivity 
 * @Description: 运动数据相关 
 * @author rw 
 * @date 2015-2-2 下午3:27:29 
 *
 */
@EActivity(R.layout.activity_motion)
public class MotionActivity extends BaseActivity {
	
	@ViewById(R.id.motion_pv)
	PathView motion_pv;
	
	@AfterViews
	public void init() {
		motion_pv.setXCount(1, 5);
		motion_pv.setType(PathView.MONTH_YEAR);
		motion_pv.setDate(new int[]{1,1,1,0,1,0,1,0,1,0,1,1});

	}
	
	@Click(R.id.back_iv)
	public void back(){
		this.finish();
	}

}
