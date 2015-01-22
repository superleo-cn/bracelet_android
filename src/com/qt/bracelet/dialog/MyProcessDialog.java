package com.qt.bracelet.dialog;

import com.qt.watch.R;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

/** 
* @ClassName: MyProcessDialog 
* @Description: 进度框 
* @author rw 
* @date 2015-1-17 下午3:27:30 
*  
*/ 
public class MyProcessDialog extends Dialog {
	public MyProcessDialog(Context context, String str) {
		super(context, R.style.MyProgressDialog);
		this.setContentView(R.layout.progress_dialog);
		TextView text = (TextView) this.findViewById(R.id.txt_wait);
		text.setText(str);
	}
}
