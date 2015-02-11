package com.qt.bracelet.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;

/** 
 * @ClassName: Bracelet 
 * @Description: 手环数据表 
 * @author rw 
 * @date 2015-2-11 下午8:12:42 
 *
 */
public class Bracelet extends Model {
	
	@Column(name = "braceletId")
	public String braceletId;

	@Column(name = "name")
	public String name;

	@Column(name = "type")
	public String type;

	@Column(name = "status")
	public String status;

	@Column(name = "createBy")
	public String createBy;

	@Column(name = "modifiedBy")
	public String modifiedBy;
	
	@Column(name = "createDate")
	public String createDate;

	@Column(name = "modifiedDate")
	public String modifiedDate;
	
	/**
	 * 判断手环是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static Bracelet checkLogin(String braceletId) {
		return new Select().from(User.class).where("braceletId = ?", braceletId).executeSingle();
	}
	
}
