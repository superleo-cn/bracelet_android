package com.qt.bracelet.component.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.AsyncTask;

import com.qt.bracelet.bean.VitalSignsBean;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.common.DateUtils;
import com.qt.bracelet.domain.VitalSignsData;
import com.qt.bracelet.mapping.VitalSignsMapping;
import com.qt.bracelet.mapping.VitalSignsMapping.VitalSigns;

/** 
 * @ClassName: UpdateUrgentListComponent 
 * @Description: 数据归档组件
 * @author rw 
 * @date 2015-2-6 下午2:12:30 
 *  
 */
public class UpdateUrgentListComponent {
	
	/**
	 * 数据归档
	 */
	public void executeUpdateUrgentList(int ids[]){
//		new UpdateUrgentList().execute(ids);
	}
	
	abstract class UpdateUrgentListTask extends AsyncTask<String, Void, Integer>{
		
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
	
	class UpdateUrgentList extends UpdateUrgentListTask{

		@Override
		Integer doExecute(String... objs) {
			return updateUrgentList();
		}
		
	}
	
	private Integer updateUrgentList(){
		return updateUrgentList(Constants.URL_UPDATEURGENTLIST_PATH);
	}
	
	private Integer updateUrgentList(String url) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("", "");
		VitalSignsMapping data = VitalSignsMapping.postJSON(url, params);
		if (data.code == Constants.STATUS_SUCCESS) {
			List<VitalSignsMapping.VitalSigns> vsList = (ArrayList<VitalSignsMapping.VitalSigns>) data.datas;
			for (VitalSigns vitalSigns : vsList) {
				VitalSignsBean bean = new VitalSignsBean();
				bean.setBraceletId(vitalSigns.braceletId);
				bean.setCreateDate(DateUtils.strToDate(Long.parseLong(vitalSigns.createDate), DateUtils.YYYY_MM_DD_HH_MM_SS));
				bean.setId(vitalSigns.id);
				bean.setMotionState(vitalSigns.motionState);
				bean.setPulseState(vitalSigns.pulseState);
				bean.setTemperature(vitalSigns.temperature);
				VitalSignsData.save(bean);
			}
		} else {
			
		}
		return data.code;
	}

}
