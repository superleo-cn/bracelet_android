package com.qt.bracelet.domain;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * @ClassName: User
 * @Description: 用户数据表
 * @author rw
 * @date 2015-2-11 下午7:36:36
 *
 */
@Table(name = "tb_user")
public class User extends Model {

	@Column(name = "uid")
	public String uid;

	@Column(name = "username")
	public String username;

	@Column(name = "password")
	public String password;

	@Column(name = "realname")
	public String realname;

	@Column(name = "userType")
	public String userType;

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

	@Column(name = "lastLoginDate")
	public String lastLoginDate;

	public List<Bracelet> bracelets;

	/**
	 * 判断用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static User checkLogin(String username) {
		User user = new Select().from(User.class).where("username = ?", username).executeSingle();
		if (user != null) {
			List<Bracelet> list = Bracelet.getByUserId(user.uid);
			user.bracelets = list;
		}
		return user;
	}

	/**
	 * 根据ID得到User
	 * 
	 * @param id
	 * @return
	 */
	public static User getUserById(Long id) {
		return Model.load(User.class, id);
	}

}
