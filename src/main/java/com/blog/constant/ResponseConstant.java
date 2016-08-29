package com.blog.constant;
/**
 * 响应数据固定格式常量
 * @author GZS
 */
public class ResponseConstant {
	//状态码 
	public static final String STATUS = "status";
	public static final String STATUS_SUCCESS = "success";//请求成功
	public static final String STATUS_ERROR = "error";//请求失败
	//错误类型
	public static final String ERROR_TYPE = "errorType";
	public static final String TYPE_NoLogin = "no_login";//未登录
	public static final String TYPE_NoAccess = "no_access";//无权限
	public static final String TYPE_NoInput = "no_input";//参数错误
	public static final String TYPE_Exception = "exception";//异常
	//错误信息
	public static final String ERROR_MSG = "msg";
	//Token标识
	public static final String TOKEN = "token";
	//统一数据标识key
	public static final String DATA = "data";
}
