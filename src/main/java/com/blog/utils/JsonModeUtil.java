package com.blog.utils;

import java.util.HashMap;
import java.util.Map;
import com.blog.constant.ResponseConstant;
/**
 * 前台接收 JSON字符串 格式
 * @author GZS
 */
public class JsonModeUtil {
	/**
	 * 请求成功
	 * @param request
	 * @return {status:success}
	 */
	public static Map<String, Object> Success() {
		Map<String, Object> map = new HashMap<>();
		map.put(ResponseConstant.STATUS, ResponseConstant.STATUS_SUCCESS);
		return map;
	}
	/**
	 * 请求成功 - 返回数据
	 * @param request
	 * @param data
	 * @return {status:success,data:***}
	 */
	public static Map<String, Object> Success(Object data) {
		Map<String, Object> map = Success();
		map.put(ResponseConstant.DATA, data);
		return map;
	}
	/**
	 * 请求失败
	 * @param request
	 * @return {status:error}
	 */
	public static Map<String, Object> Error() {
		Map<String, Object> map = new HashMap<>();
		map.put(ResponseConstant.STATUS, ResponseConstant.STATUS_ERROR);
		return map;
	}
	/**
	 * 请求失败-系统异常
	 * @param request
	 * @param msg
	 * @return {status:error,errorType:exception,msg:***}
	 */
	public static Map<String, Object> Error_Exception(String msg) {
		Map<String, Object> map = Error(); 
		map.put(ResponseConstant.ERROR_TYPE, ResponseConstant.TYPE_Exception);
		map.put(ResponseConstant.ERROR_MSG, msg);
		return map;
	}
	/**
	 * 请求失败-参数错误
	 * @param request
	 * @param msg
	 * @return {status:error,errorType:no_input,msg:***}
	 */
	public static Map<String, Object> Error_NoInput(String msg) {
		Map<String, Object> map = Error(); 
		map.put(ResponseConstant.ERROR_TYPE, ResponseConstant.TYPE_NoInput);
		map.put(ResponseConstant.ERROR_MSG, msg);
		return map;
	}
	/**
	 * 请求失败-无权限
	 * @param request
	 * @param msg
	 * @return {status:error,errorType:no_access}
	 */
	public static Map<String, Object> Error_NoAccess() {
		Map<String, Object> map = Error(); 
		map.put(ResponseConstant.ERROR_TYPE, ResponseConstant.TYPE_NoAccess);
		return map;
	}
	/**
	 * 请求失败-未登录
	 * @param request
	 * @param msg 
	 * @return {status:error,errorType:no_login}
	 */
	public static Map<String, Object> Error_NoLogin() {
		Map<String, Object> map = Error(); 
		map.put(ResponseConstant.ERROR_TYPE, ResponseConstant.TYPE_NoLogin);
		return map;
	}
}
