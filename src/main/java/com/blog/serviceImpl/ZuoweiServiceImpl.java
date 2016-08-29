package com.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.Dao.UserMapper;
import com.blog.Dao.ZuoweiMapper;
import com.blog.service.OrderService;
import com.blog.service.ZuoweiService;
@Service("zuoweiService")
public class ZuoweiServiceImpl implements ZuoweiService{
	@Resource
	private ZuoweiMapper zuoweiDao;
}
