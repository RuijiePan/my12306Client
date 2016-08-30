package com.blog.utils;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtil{
	private HttpServletResponse response;
	public ResponseUtil(HttpServletResponse response) {
		this.response = response;
		this.response.setCharacterEncoding("utf-8");
		this.response.setContentType("application/json;charset=utf-8");
	}
	public void writeStringJson(String tojson){
		PrintWriter out = null;
		try {
			out = response.getWriter();
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
			out = response.getWriter();
			out.write(tojson);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}

}
