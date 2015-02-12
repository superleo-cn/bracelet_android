package com.qt.bracelet.component.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.EBean;
import com.qt.bracelet.bean.VitalSignsBean;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.common.DateUtils;
import com.qt.bracelet.domain.VitalSignsData;
import com.qt.bracelet.mapping.VitalSignsMapping;
import com.qt.bracelet.mapping.VitalSignsMapping.VitalSigns;

/** 
 * @ClassName: ObtainVitalSignsComponent 
 * @Description: 获取生命体征数据组件 
 * @author rw 
 * @date 2015-1-19 下午2:49:48 
 *  
 */
@EBean
public class ObtainVitalSignsComponent {
	
	/**
	 * 获取生命体征数据
	 */
	public void executeObtainData(){
		new ObtainVialSigns().execute();
	}
	
	abstract class ObtainVitalSignsTask extends AsyncTask<String, Void, Integer>{
		
		abstract Integer doExecute(String... objs);

		@Override
		protected Integer doInBackground(String... objs) {
			return doExecute(objs);
		}

		@Override
		protected void onPostExecute(Integer result) {
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
		
	}
	
	class ObtainVialSigns extends ObtainVitalSignsTask{

		@Override
		Integer doExecute(String... objs) {
			return obtainVitalSigns();
		}
		
	}
	
	private Integer obtainVitalSigns(){
		return obtainVitalSigns(Constants.URL_FINDBYBRACELETANDDATE_PATH+"1234567" + "/20150204");
	}
	
	private Integer obtainVitalSigns(String url) {
		Map<String, String> params = new HashMap<String, String>();
//		params.put("username", "leo");
//		params.put("password", "123");
		VitalSignsMapping data = VitalSignsMapping.postJSON(url, params);
		if (data.code == Constants.STATUS_SUCCESS) {
//			List<VitalSignsMapping.VitalSigns> vsList = (ArrayList<VitalSignsMapping.VitalSigns>) data.datas;
//			for (VitalSigns vitalSigns : vsList) {
//				VitalSignsBean bean = new VitalSignsBean();
//				bean.setBraceletId(vitalSigns.braceletId);
//				bean.setCreateDate(DateUtils.strToDate(Long.parseLong(vitalSigns.createDate), DateUtils.YYYY_MM_DD_HH_MM_SS));
//				bean.setId(vitalSigns.id);
//				bean.setMotionState(vitalSigns.motionState);
//				bean.setPulseState(vitalSigns.pulseState);
//				bean.setTemperature(vitalSigns.temperature);
//				VitalSignsData.save(bean);
//			}
		} else {
			
		}
		return data.code;
	}

}
