package com.blog.utils;

import java.util.ArrayList;
import java.util.List;

public class StrUtil {
	/**
	 * 分割字符串
	 * @param readyStr 待分割的字符串
	 * @param code 分割符
	 * @return
	 */
	public static List<String> split(String readyStr,String code){
		String[] sss = readyStr.split(code);
		List<String> strs =  new ArrayList<>();
		for (String string : sss) {
			strs.add(string);
		}
		return strs;
	}
}
