package com.qt.bracelet.widget;

import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;

/**
 * @ClassName: PathView
 * @Description: 曲线试图
 * @author rw
 * @date 2015-2-13 上午11:52:19
 * 
 */
public class PathView extends View {

	public static final int DAY_WEEK = 0;
	public static final int DAY_MONTH = 1;
	public static final int WEEK_MONTH = 2;
	public static final int MONTH_YEAR = 3;

	public String[] days = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
	public String[] weeks = { "第一周", "第二周", "第三周", "第四周" };
	public String[] mouths = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",
			"九月", "十月", "十一月", "十二月", };
	public String[] days_month = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	public ArrayList<Float> xPoint = new ArrayList<Float>();

	public int defaultType = DAY_WEEK;
	public String[] defaultDay = days;

	// x,y轴的线条数量
	private int xLineCount = 10;
	private int yLineCount = 10;
	private Paint paintLine, paintPoint, textPaint, linkPaint;
	private int[] data;

	// 靠左侧，底部的距离
	private float left;
	private float bottom;

	// x,y轴上显示的值
	private float xMaxValue, yMaxValue;
	// 间距
	private float xInterval, yInterval;

	public PathView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public PathView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public PathView(Context context) {
		super(context);
		init(context);
	}

	public void setType(int type) {
		defaultType = type;
	}

	private void init(Context cont) {
		paintLine = new Paint();
		paintLine.setAntiAlias(true);
		paintLine.setColor(Color.WHITE);
		paintLine.setFakeBoldText(true);
		paintLine.setStrokeWidth(1.5f);

		paintPoint = new Paint();
		paintPoint.setColor(Color.RED);
		paintPoint.setFakeBoldText(true);
		paintPoint.setStrokeWidth(20);

		textPaint = new Paint();
		textPaint.setColor(Color.BLUE);
		textPaint.setFakeBoldText(true);
		textPaint.setTextSize(15);

		linkPaint = new Paint();
		linkPaint.setColor(Color.BLUE);
		linkPaint.setFakeBoldText(true);
		linkPaint.setTextSize(25);
	}

	public void setTextSize(int size) {
		textPaint.setTextSize(size);
	}

	public void setDate(int[] x) {
		data = x;
		invalidate();
	}

	private void calculateLeft() {
		for (int value : data) {
			float tempLeft = textPaint.measureText(value + "");
			if (tempLeft > left) {
				left = tempLeft;
			}
		}
		bottom = textPaint.getFontMetrics().descent - textPaint.getFontMetrics().ascent;
		switch (defaultType) {
		case DAY_MONTH:
			yLineCount = getCurrentMonthLastDay() + 1;
			defaultDay = days_month;
			break;
		case DAY_WEEK:
			yLineCount = 8;
			defaultDay = days;
			break;
		case MONTH_YEAR:
			yLineCount = 13;
			defaultDay = mouths;
			break;
		case WEEK_MONTH:
			yLineCount = 5;
			defaultDay = weeks;
			break;
		}
		if (xMaxValue == 0)
			xMaxValue = this.getWidth() - left;
		if (xInterval == 0)
			xInterval = (this.getHeight() - bottom) / (xLineCount + 1);
		if (yMaxValue == 0)
			yMaxValue = this.getHeight() - bottom;
		if (yInterval == 0)
			yInterval = (this.getWidth() - left) / yLineCount;
	}

	private int getCurrentMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public void setMaxX(int maxValue, int width) {
		xLineCount = maxValue / width + 1;
		xMaxValue = maxValue;
	}

	public void setMaxY(int maxValue, int height) {
		yLineCount = maxValue / height + 1;
		yMaxValue = maxValue;
	}

	public void setXCount(int maxValue, int count) {
		xLineCount = count;
		xMaxValue = maxValue;
	}

	public void setYCount(int maxValue, int count) {
		yLineCount = count;
		yMaxValue = maxValue;
	}

	/**
	 * 绘制曲线
	 * 
	 * @param canvas
	 */
	private void doDraw(Canvas canvas) {
		float sumHeight = xLineCount * xInterval;
		float tempInterval = xMaxValue / sumHeight;
		for (int i = 0; i < data.length; i++) {
			float x = xPoint.get(i);
			float yPotion = sumHeight - data[i] / tempInterval + xInterval;
			canvas.drawCircle(x, yPotion, 5, paintPoint);
			if (i != data.length - 1) {
				float nextYPotion = sumHeight - data[i + 1] / tempInterval
						+ xInterval;
				canvas.drawLine(x, yPotion, xPoint.get(i + 1), nextYPotion,
						linkPaint);
			}
		}
	}

	/**
	 * 绘制连框
	 */
	private void drawFrame(Canvas canvas) {
		calculateLeft();
		// 绘制横线
		for (int i = 0; i <= xLineCount; i++) {
			float startY = i * xInterval + xInterval;
			canvas.drawLine(left + 5, startY, getWidth(), startY, paintLine);
			textPaint.setTextAlign(Align.RIGHT);
			canvas.drawText(
					Math.round(xMaxValue / xLineCount * (xLineCount - i) - 0.5)
							+ "", left, startY + bottom / 4, textPaint);
		}
		for (int j = 0; j < yLineCount; j++) {
			float leftSpace = yInterval * j + left + 5;
			canvas.drawLine(leftSpace, bottom, leftSpace, this.getHeight()
					- bottom, paintLine);
			textPaint.setTextAlign(Align.CENTER);
			if (j == 0) {
				continue;
			}
			xPoint.add(leftSpace);
			canvas.drawText(defaultDay[j - 1], leftSpace, this.getHeight(),
					textPaint);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		drawFrame(canvas);
		doDraw(canvas);
		super.onDraw(canvas);
	}

}
