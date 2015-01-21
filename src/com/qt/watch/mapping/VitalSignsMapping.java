package com.qt.watch.mapping;

import java.util.Map;

import com.qt.watch.common.RestHelper;

/** 
 * @ClassName: VitalSignsMapping 
 * @Description: 生命体征数据JSON封装 
 * @author rw 
 * @date 2015-1-19 下午4:18:16 
 *  
 */
public class VitalSignsMapping extends BasicMapping<VitalSignsMapping.VitalSigns> {
	
	public static final VitalSignsMapping mapping = new VitalSignsMapping();
	
	public static class VitalSigns {
		public String id;
		public String motionState;
		public String pulseState;
		public String temperature;
		public String braceletId;
		public String createDate;
	}
	
	public static VitalSignsMapping postJSON(String url, Map<String, String> params){
		VitalSignsMapping result = RestHelper.postJSON(url, VitalSignsMapping.class, params);
		return result != null ? result : mapping;
	}

}
