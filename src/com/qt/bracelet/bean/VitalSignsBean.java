package com.qt.bracelet.bean;

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
	public String sbp;
	public String dbp;
	public String warning;
	public String archive;
	
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
	/**
	 * @return the sbp
	 */
	public String getSbp() {
		return sbp;
	}
	/**
	 * @param sbp the sbp to set
	 */
	public void setSbp(String sbp) {
		this.sbp = sbp;
	}
	/**
	 * @return the dbp
	 */
	public String getDbp() {
		return dbp;
	}
	/**
	 * @param dbp the dbp to set
	 */
	public void setDbp(String dbp) {
		this.dbp = dbp;
	}
	/**
	 * @return the warning
	 */
	public String getWarning() {
		return warning;
	}
	/**
	 * @param warning the warning to set
	 */
	public void setWarning(String warning) {
		this.warning = warning;
	}
	/**
	 * @return the archive
	 */
	public String getArchive() {
		return archive;
	}
	/**
	 * @param archive the archive to set
	 */
	public void setArchive(String archive) {
		this.archive = archive;
	}
	@Override
	public String toString() {
		return "VitalSignsBean [id=" + id + ", motionState=" + motionState
				+ ", pulseState=" + pulseState + ", temperature=" + temperature
				+ ", braceletId=" + braceletId + ", createDate=" + createDate
				+ ", sbp=" + sbp + ", dbp=" + dbp + ", warning=" + warning
				+ ", archive=" + archive + "]";
	}
	
}
