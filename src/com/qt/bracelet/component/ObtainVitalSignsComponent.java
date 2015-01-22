package com.qt.bracelet.component;

import java.util.HashMap;
import java.util.Map;

import android.os.AsyncTask;

import com.googlecode.androidannotations.annotations.EBean;
import com.qt.bracelet.bean.VitalSignsBean;
import com.qt.bracelet.common.Constants;
import com.qt.bracelet.mapping.VitalSignsMapping;

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
		return obtainVitalSigns(Constants.URL_OBTAILVITALSIGNS_PATH);
	}
	
	private Integer obtainVitalSigns(String url) {
		Map<String, String> params = new HashMap<String, String>();
		VitalSignsMapping data = VitalSignsMapping.postJSON(url, params);
		if (data.code == Constants.STATUS_SUCCESS) {
			VitalSignsMapping.VitalSigns vitalSigns = data.datas.get(0);
			VitalSignsBean vitalSignsBean = new VitalSignsBean();
			
		}
		return data.code;
	}

}
