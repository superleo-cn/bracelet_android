/**
 *  ClassName: MyApp.java
 *  created on 2013-1-24
 *  Copyrights 2013-1-24 hjgang All rights reserved.
 *  site: http://t.qq.com/hjgang2012
 *  email: hjgang@yahoo.cn
 */
package com.qt.bracelet.common;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

/** 
* @ClassName: RestHelper 
* @Description: HttpClient来发请求并返回字符串内容的工具类
* 注意：需要添加权限&lt;uses-permission android:name="android.permission.INTERNET"/&gt;
* @author rw 
* @date 2015-2-12 上午10:22:28 
*
*/ 
public class RestHelper {

	static Gson gson = new Gson();

	public static <T> T postJSON(String url, Class<T> t, Map<String, String> params) {
		try {
			String json = HttpHelper.post(url, params);
			if (StringUtils.isNotEmpty(json) && !StringUtils.equalsIgnoreCase("null", json)) {
				// 注意:目前服务器返回的JSON数据串中会有特殊字符（换行、回车）。需要处理一下
				return gson.fromJson(cleanJSON(json), t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static <T> T getJSON(String url, Class<T> t) {
		try {
			String json = HttpHelper.get(url);
			if (StringUtils.isNotEmpty(json) && !StringUtils.equalsIgnoreCase("null", json)) {
				return gson.fromJson(cleanJSON(json), t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private static String cleanJSON(String json) {
		// 注意:目前服务器返回的JSON数据串中会有特殊字符（换行、回车）。需要处理一下
		return json.replaceAll("\\x0a|\\x0d", "");
	}

}