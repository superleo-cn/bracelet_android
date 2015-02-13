package com.qt.bracelet.common;

/** 
* @ClassName: Constants 
* @Description: 常量类 
* @author rw 
* @date 2015-1-19 下午2:03:21 
*  
*/ 
public final class Constants {
	private Constants() {
	}

	/** 与服务器端连接的协议名 */
	public static final String PROTOCOL = "http://";
	/** 服务器IP */
//	public static final String HOST = "54.169.209.8";
	public static final String HOST = "ec2-54-169-209-8.ap-southeast-1.compute.amazonaws.com";
	
	/** 服务器端口号 */
	 public static final String PORT = ":80";
	/** 应用上下文名 */
	public static final String APP = "";
	/** 应用上下文完整路径 */
	public static final String URL_CONTEXTPATH = PROTOCOL + HOST + PORT;
	
	/** 登录URL路径 */
	public static final String URL_LOGIN_PATH = URL_CONTEXTPATH + "/loginJson";
	/** 根据手环ID获取数据URL路径 example:/api/findUrgentByBracelet/1234567 */
	public static final String URL_FINDURGENTBYBRACELET_PATH = URL_CONTEXTPATH + "/api/findUrgentByBracelet/";
	/** 根据时间查询手环对应的数据URL路径 example:api/findByBraceletAndDate/1234567/20150204 */
	public static final String URL_FINDBYBRACELETANDDATE_PATH = URL_CONTEXTPATH + "/api/findByBraceletAndDate/";
	/** 根据时间查询手环对应的数据URL路径  */
	public static final String URL_UPDATEURGENTLIST_PATH = URL_CONTEXTPATH + "/updateUrgentList";
//	public static final String URL_OBTAILVITALSIGNS_PATH = URL_CONTEXTPATH + "/api/findAll";
//	/** 根据日期查询数据URL路径 example:/api/findByDate/20150112000000 */
//	public static final String URL_OBTAILVITALSIGNSBYDATE_PATH = URL_CONTEXTPATH + "/api/findByDate";
	
	// 返回结果判断
	public static final int STATUS_SUCCESS = 1;
	public static final int STATUS_FAILED = 0;
	public static final int STATUS_SERVER_FAILED = -1;
	public static final int STATUS_NETWORK_ERROR = -2;
	
	// 数据是否归档
	public static final int ARCHIVE_YES = 1;
	public static final int ARCHIVE_NO = 0;
	
}
