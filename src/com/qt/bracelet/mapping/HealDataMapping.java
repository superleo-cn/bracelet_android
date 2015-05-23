package com.qt.bracelet.mapping;

import com.qt.bracelet.common.RestHelper;

import java.util.Map;

/** 
 * @ClassName: VitalSignsMapping 
 * @Description: 生命体征数据JSON封装 
 * @author rw 
 * @date 2015-1-19 下午4:18:16 
 *  
 */
public class HealDataMapping extends BasicObjectMapping<HealDataMapping.HealData> {
	
	public static final HealDataMapping mapping = new HealDataMapping();
	
	public static class HealData {
		public String id;
		public String motionState;
		public String pulseState;
		public String temperature;
		public String sbp;
		public String dbp;
		public String warning;
		public String archive;
		public String braceletId;
		public String createDate;
	}
	
	public static HealDataMapping getJSON(String url){
		HealDataMapping result = RestHelper.getJSON(url, HealDataMapping.class);
		return result != null ? result : mapping;
	}

}
