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
//http://localhost:8080/my12306/user/mine/register?username=1&password=1&nickname=1&idcard=1&email=1&identity=1&phone=1&url=1&status=1&token=1
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private UserService userService;

	@RequestMapping("/mine/register")
	public void register(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.register(user));
	}

	@RequestMapping("/mine/login")
	public void login(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.login(user));
	}

	@RequestMapping("/mine/quit")
	public void quit(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.quit(user));
	}

	@RequestMapping("/mine/search_linkman")
	public void search_linkman(User user,HttpServletRequest request,HttpServletResponse response){

	}

	@RequestMapping("/mine/search_personalinfo")
	public void search_personalinfo(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.getInfo(user));
	}

	@RequestMapping("/mine/update_personalinfo")
	public void update_personalinfo(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.updateInfo(user));
	}

	@RequestMapping("/mine/add_linkman")
	public void add_linkman(User user,HttpServletRequest request,HttpServletResponse response){

	}
}
