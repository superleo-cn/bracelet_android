package com.qt.bracelet.component.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.qt.bracelet.bean.VitalSignsBean;
import com.qt.bracelet.common.BraceletApp;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.common.DateUtils;
import com.qt.bracelet.component.ActivityComponent;
import com.qt.bracelet.component.StringResComponent;
import com.qt.bracelet.component.ToastComponent;
import com.qt.bracelet.component.WifiComponent;
import com.qt.bracelet.dialog.MyProcessDialog;
import com.qt.bracelet.domain.User;
import com.qt.bracelet.domain.VitalSignsData;
import com.qt.bracelet.mapping.VitalSignsMapping;
import com.qt.bracelet.mapping.VitalSignsMapping.VitalSigns;

/** 
 * @ClassName: ArchiveComponent 
 * @Description: 数据归档组件
 * @author rw 
 * @date 2015-2-14 下午2:59:41 
 *
 */
@EBean
public class ArchiveComponent {
	
	@Bean
	ToastComponent toastComponent;
	
	@Bean
	StringResComponent stringResComponent;
	
	@Bean
	WifiComponent wifiComponent;
	
	@Bean
	ActivityComponent activityComponent;
	
	@Bean
	ArchiveComponent archiveComponent;
	
	@RootContext
	Context context;
	
	@RootContext
	Activity activity;
	
	@App
	BraceletApp braceletApp;
	
	MyProcessDialog dialog;
	
	/**
	 * 获取生命体征数据
	 */
	public void archiveData(String[] ids){
		new ArchiveVialSigns().execute(ids);
	}
	
	abstract class ArchiveVitalSignsTask extends AsyncTask<String, Void, Integer>{
		
		abstract Integer doExecute(String... objs);

		@Override
		protected Integer doInBackground(String... objs) {
			return doExecute(objs);
		}

		@Override
		protected void onPostExecute(Integer result) {
			dialog.dismiss();
			switch (result) {
			case Constants.STATUS_FAILED:
				toastComponent.show(stringResComponent.update_failed);
				break;
			case Constants.STATUS_SUCCESS:
				toastComponent.show(stringResComponent.update_success);
				break;
			case Constants.STATUS_SERVER_FAILED:
				toastComponent.show(stringResComponent.server_error);
				break;
			case Constants.STATUS_NETWORK_ERROR:
				toastComponent.show(stringResComponent.wifi_error);
				break;
			}
		}

		@Override
		protected void onPreExecute() {
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
	}
	
	class ArchiveVialSigns extends ArchiveVitalSignsTask{

		@Override
		Integer doExecute(String... objs) {
			return archiveVitalSigns();
		}
	}
	
	private Integer archiveVitalSigns(){ // 获取手环ID，从而获取手环数据
		User user = User.checkLogin(braceletApp.getUsername());
		if (user == null) {
			toastComponent.show("用户不存在");
			return Constants.STATUS_NETWORK_ERROR;
		} else {
			return obtainVitalSigns(Constants.URL_FINDURGENTBYBRACELET_PATH + "1234567");
		}
	}
	
	/**
	 * 获取手环数据，并进行本地保存
	 * 
	 * @param url
	 * @return
	 */
	private Integer obtainVitalSigns(String url) {
		Map<String, String> params = new HashMap<String, String>();
		VitalSignsMapping data = VitalSignsMapping.postJSON(url, params);
		if (data.code == Constants.STATUS_SUCCESS) {
			List<VitalSignsMapping.VitalSigns> vsList = (ArrayList<VitalSignsMapping.VitalSigns>) data.datas;
			ArrayList<String> ids = new ArrayList<String>();
			for (VitalSigns vitalSigns : vsList) {
				VitalSignsBean bean = new VitalSignsBean();
				bean.setBraceletId(vitalSigns.braceletId);
				bean.setCreateDate(DateUtils.strToDate(Long.parseLong(vitalSigns.createDate), DateUtils.YYYY_MM_DD_HH_MM_SS));
				String id = vitalSigns.id;
				bean.setId(id);
				bean.setMotionState(vitalSigns.motionState);
				bean.setPulseState(vitalSigns.pulseState);
				bean.setTemperature(vitalSigns.temperature);
				bean.setSbp(vitalSigns.sbp);
				bean.setDbp(vitalSigns.dbp);
				bean.setArchive(vitalSigns.archive);
				bean.setWarning(vitalSigns.warning);
				VitalSignsData.save(bean);
				ids.add(id);
			}
			// 归档操作
			String[] allId = (String[]) ids.toArray();
			
		}
		
		activityComponent.startMain();
		activity.finish();
		return data.code;
	}

}
