package com.qt.watch.bean;

/** 
 * @ClassName: VitalSignsBean 
 * @Description: 生命体征数据Bean 
 * @author rw 
 * @date 2015-1-19 下午2:44:07 
 *  
 */
public class VitalSignsBean {
	
	public String id;
	public String motionState;
	public String pulseState;
	public String temperature;
	public String braceletId;
	public String createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMotionState() {
		return motionState;
	}
	public void setMotionState(String motionState) {
		this.motionState = motionState;
	}
	public String getPulseState() {
		return pulseState;
	}
	public void setPulseState(String pulseState) {
		this.pulseState = pulseState;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getBraceletId() {
		return braceletId;
	}
	public void setBraceletId(String braceletId) {
		this.braceletId = braceletId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "VitalSignsBean [id=" + id + ", motionState=" + motionState
				+ ", pulseState=" + pulseState + ", temperature=" + temperature
				+ ", braceletId=" + braceletId + ", createDate=" + createDate
				+ "]";
	}
	
}
