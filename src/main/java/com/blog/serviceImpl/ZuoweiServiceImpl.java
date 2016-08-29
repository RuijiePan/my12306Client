package com.blog.serviceImpl;

import javax.annotation.Resource;

import com.blog.Dao.UserMapper;
import com.blog.Dao.ZuoweiMapper;
import com.blog.service.OrderService;
import com.blog.service.ZuoweiService;

public class ZuoweiServiceImpl implements ZuoweiService{
	@Resource
	private ZuoweiMapper zuoweiDao;
}
