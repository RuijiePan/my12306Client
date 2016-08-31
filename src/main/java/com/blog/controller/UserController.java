package com.blog.controller;

import com.blog.entity.Link;
import com.blog.entity.User;
import com.blog.service.LinkService;
import com.blog.service.UserService;
import com.blog.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户管理
 * @author GZS
 */
//http://localhost:8080/my12306/user/mine/register?username=1&password=1&nickname=1&idcard=1&email=1&identity=1&phone=1&url=1&status=1&token=1
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private UserService userService;
	@Resource
	private LinkService linkService;

	@RequestMapping("/register")
	public void register(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.register(user));
	}

	@RequestMapping("/login")
	public void login(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.login(user));
	}

	@RequestMapping("/quit")
	public void quit(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.quit(user));
	}


	@RequestMapping("/search_personalinfo")
	public void search_personalinfo(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.getInfo(user));
	}

	@RequestMapping("/update_personalinfo")
	public void update_personalinfo(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.updateInfo(user));
	}

	@RequestMapping("/search_linkman")
	public void search_linkman(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,linkService.getLinker(user));
	}

	@RequestMapping("/add_linkman")
	public void add_linkman(Link link,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,linkService.insertLinker(link));
	}
}
