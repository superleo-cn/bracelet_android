package com.qt.bracelet.common;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/** 
* @ClassName: DateUtils 
* @Description: 日期工具类
* @author rw 
* @date 2015-1-27 下午4:59:38 
*
*/ 
public class DateUtils {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD_HH_MM_SS = "yyyyMMddHHmmss";

	public static String dateToStr(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}
	
	public static String strToDate(long millis, String pattern){
		return DateFormatUtils.format(millis, pattern);
	}

}
