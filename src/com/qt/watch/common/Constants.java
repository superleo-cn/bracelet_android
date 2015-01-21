package com.qt.watch.common;

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
	public static final String HOST = "54.169.209.8";
	/** 服务器端口号 */
	 public static final String PORT = ":80";
	/** 应用上下文名 */
	public static final String APP = "";
	/** 应用上下文完整路径 */
	public static final String URL_CONTEXTPATH = PROTOCOL + HOST + PORT;
	/** 查询所有数据URL路径 */
	public static final String URL_OBTAILVITALSIGNS_PATH = URL_CONTEXTPATH + "/api/findAll";
	/** 根据日期查询数据URL路径 */
	public static final String URL_OBTAILVITALSIGNSBYDATE_PATH = URL_CONTEXTPATH + "/api/findByDate";
	
	public static final int STATUS_SUCCESS = 1;
	public static final int STATUS_FAILED = 0;
	public static final int STATUS_SERVER_FAILED = -1;
	public static final int STATUS_NETWORK_ERROR = -2;
	
}
