package com.qt.bracelet.activity;

import com.googlecode.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

/** 
* @ClassName: BaseActivity 
* @Description: 基础Activity类 
* @author rw 
* @date 2014-12-24 下午4:36:05 
*  
*/ 
@EActivity
public class BaseActivity extends Activity implements OnTouchListener {

	// 手指向右滑动时的最小速度
	private static final int SPEED_MIN = 200;

	// 手指向右滑动时的最小距离
	private static final int DISTANCE_MIN = 150;

	// 记录手指按下时的横坐标
	private float xDown;

	// 记录手指移动时的横坐标
	private float xMove;

	// 用户计算手指滑动的速度
	private VelocityTracker mVelocityTracker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
						| WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		createVelocityTracker(event);
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			xDown = event.getRawX();
			break;
		case MotionEvent.ACTION_MOVE:
			xMove = event.getRawX();
			int distanceX = (int) (xMove - xDown);
			int xSpeed = getScrollVelocity();
			if (distanceX > DISTANCE_MIN && xSpeed > SPEED_MIN) {
				finish();
				// overridePendingTransition(R.anim.slide_left_in,
				// R.anim.slide_right_out);
			}
			break;
		case MotionEvent.ACTION_UP:
			recycleVelocityTracker();
			break;
		default:
			break;
		}
		return true;
	}

	/**
	 * 创建VelocityTracker对象，并将触摸content界面的滑动事件加入到VelocityTracker当中
	 * 
	 * @param event
	 */
	private void createVelocityTracker(MotionEvent event) {
		if (mVelocityTracker == null) {
			mVelocityTracker = VelocityTracker.obtain();
		}
		mVelocityTracker.addMovement(event);
	}

	/**
	 * 回收VelocityTracker对象。
	 */
	private void recycleVelocityTracker() {
		mVelocityTracker.recycle();
		mVelocityTracker = null;
	}

	/**
	 * 获取手指在content界面滑动的速度
	 * 
	 * @return 滑动速度，以每秒移动了多少像素为单位
	 */
	private int getScrollVelocity() {
		mVelocityTracker.computeCurrentVelocity(1000);
		int velocity = (int) mVelocityTracker.getXVelocity();
		return Math.abs(velocity);
	}

}
