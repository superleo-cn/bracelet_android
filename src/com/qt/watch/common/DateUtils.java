package com.qt.watch.common;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * Date Help Class
 * 
 * @author Hu Bo
 */
public class DateUtils {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD_HH_MM_SS = "yyyyMMddHHmmss";

	public static String dateToStr(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

}
