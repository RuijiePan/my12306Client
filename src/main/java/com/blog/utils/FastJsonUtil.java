package com.blog.utils;



import com.alibaba.fastjson.JSON;


public class FastJsonUtil {
	public static String toJson(Object obj){
		return JSON.toJSONString(obj);
	}
	
	public static <T> T toObject(String json, Class<T> classOfT){
		return JSON.parseObject(json, classOfT);
	}
}
