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

	//http://172.18.0.139:8080/user/my12306/register?username=%E5%93%88%E5%93%88&password=131&phone=43423&nickname=12312&email=21321&idcard=21321&identity=12321&url=21312&status=21321&token=1
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


	//localhost:8080/my12306/user/search_personalinfo?uid=5&token=MDsdkO278kyK667U1hu
	@RequestMapping("/search_personalinfo")
	public void search_personalinfo(User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,userService.getInfo(user));
	}

	//http://localhost:8080/my12306/user/update_personalinfo?uid=5&token=MDsdkO278kyK667U1hu&username=haha&password=asfh&nickname=hhh&idcard=23432&email=asdsadk&identity=243423&phone=12321&url=21321&status=23423
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

	//http://localhost:8080/my12306/user/add_linkman?uid=5&token=MDsdkO278kyK667U1hu&phone=5543&idcard=3325234&identity=asasfas
	@RequestMapping("/add_linkman")
	public void add_linkman(Link link,User user,HttpServletRequest request,HttpServletResponse response){
		ResponseUtil.getInstance()
				.writeOTJson(response,linkService.insertLinker(link,user));
	}
}
