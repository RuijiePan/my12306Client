package com.blog.utils;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtil{

	private static ResponseUtil instance;
	private HttpServletResponse response;

	public static ResponseUtil getInstance(){
		if(instance==null){
			synchronized (ResponseUtil.class){
				if (instance==null)
					instance = new ResponseUtil();
			}
		}
		return instance;
	}

	private ResponseUtil() {

	}

	public ResponseUtil setResonse(HttpServletResponse response){
		instance.response = response;
		instance.response.setCharacterEncoding("utf-8");
		instance.response.setContentType("application/json;charset=utf-8");
		return instance;
	}

	public static void writeStringJson(String tojson){
		PrintWriter out = null;
		try {
			out = instance.response.getWriter();
			out.write(tojson);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	public void writeObjectJson(Object myresponse){
		String tojson = FastJsonUtil.toJson(myresponse);
		PrintWriter out = null;
		try {
			out = instance.response.getWriter();
			out.write(tojson);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}

	public void writeOTJson(HttpServletResponse response,Object myresponse){
		ResponseUtil.getInstance()
				.setResonse(response)
				.writeObjectJson(myresponse);
	}

}
