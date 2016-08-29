package com.blog.utils;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
public class HttpUtil {
	/**
	 * 后台封装JSON字符串并发送到前端
	 * @param response
	 * @param obj
	 */
	public static void send(HttpServletResponse response,Object obj){
		response.setContentType("application/json;charset=utf-8");
		//对外开放API
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out =null;
		try {
			out = response.getWriter();
			out.println(JSON.toJSONString(obj));
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
}
