package com.blog.controller;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.entity.User;
import com.blog.service.CheciService;
import com.blog.service.OrderService;
import com.blog.service.UserService;
/**
 * 用户管理
 * @author GZS
 */
//http://localhost:8080/wu/user/register?uid=1&username=1&password=1&nickname=1&idcard=1&email=1&identity=1&phone=1

@Controller
@RequestMapping("/checi")
public class CheciController extends BaseController{
	
	@Resource
	private CheciService checiService;
}
