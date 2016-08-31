package com.blog.controller;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.entity.User;
import com.blog.myresponse.MyResponse;
import com.blog.service.UserService;
import com.blog.utils.ResponseUtil;
/**
 * 用户管理
 * @author GZS
 */
//http://localhost:8080/my12306/user/register?uid=1&username=1&password=1&nickname=1&idcard=1&email=1&identity=1&phone=1&url=1
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private UserService userService;

	@RequestMapping("/register")
	public void register(User user,HttpServletRequest request,HttpServletResponse response){
		boolean status = userService.register(user);
		ResponseUtil responseUtil = new ResponseUtil(response);
		MyResponse myResponse = new MyResponse();
		myResponse.setData(user);
		responseUtil.writeObjectJson(myResponse);
	}
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("========/test2222=========");
		response.getWriter().write("test");
	}
}
