package com.qt.bracelet.mapping;

import java.util.List;
import java.util.Map;

import com.qt.bracelet.common.RestHelper;

public class UserMapping extends BasicObjectMapping<UserMapping.User> {

	private static final UserMapping mapping = new UserMapping();
	
	public static class User {

		public String id;

		public String username;

		public String password;

		public String realname;

		public String userType;

		public String status;
		
		public String createBy;

		public String modifiedBy;

		public String createDate;
		
		public String modifiedDate;
		
		public String lastLoginDate;

		public List<Bracelets> bracelets;
	}

	public static class Bracelets {
		
		public String id;
		
		public String braceletId;

		public String name;

		public String type;

		public String status;

		public String createBy;

		public String modifiedBy;
		
		public String createDate;

		public String modifiedDate;

	}

	public static UserMapping postJSON(String url, Map<String, String> params) {
		UserMapping result = RestHelper.postJSON(url, UserMapping.class, params);
		return result != null ? result : mapping;
	}
}
