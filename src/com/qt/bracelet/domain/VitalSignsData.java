package com.qt.bracelet.domain;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.qt.bracelet.bean.VitalSignsBean;

/** 
* @ClassName: VitalSignsData 
* @Description: 生命体征数据表 
* @author rw 
* @date 2015-1-22 下午4:20:27 
*  
*/ 
@Table(name = "tb_vitalsigns_data")
public class VitalSignsData extends Model {

	@Column(name = "vs_id")
	public String vsId;

	@Column(name = "motion_state")
	public String motionState;

	@Column(name = "pulse_state")
	public String pulseState;
	
	@Column(name = "temperature")
	public String temperature;

	@Column(name = "bracelet_id")
	public String braceletId;

	@Column(name = "createDate")
	public String createDate;

	@Override
	public String toString() {
		return "VitalSignsData [vsId=" + vsId + ", motionState=" + motionState
				+ ", pulseState=" + pulseState + ", temperature=" + temperature
				+ ", braceletId=" + braceletId + ", createDate=" + createDate
				+ "]";
	}

	/**
	 * 返回生命体征数据列表前N条数据
	 * 
	 * @param size
	 * @return
	 */
	public static List<VitalSignsData> queryListByStatus(int size) {
		return new Select().from(VitalSignsData.class).limit("0, " + size).execute();
	}

	/**
	 * 返回全部生命体征数据列表
	 * 
	 * @return
	 */
	public static List<VitalSignsData> queryAllList() {
		return new Select().from(VitalSignsData.class).execute();
	}

	/**
	 * 保存生命体征数据到本地
	 * 
	 * @param bean
	 */
	public static void save(VitalSignsBean bean) {
		if (StringUtils.isNotEmpty(bean.getId())) {
			VitalSignsData vsData = new VitalSignsData();
			vsData.vsId = bean.getId();
			vsData.braceletId = bean.getBraceletId();
			vsData.motionState = bean.getMotionState();
			vsData.pulseState = bean.getPulseState();
			vsData.temperature = bean.getTemperature();
			vsData.createDate = bean.getCreateDate();
			vsData.save();
		}
	}

}
