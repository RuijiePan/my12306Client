package com.blog.serviceImpl;

import javax.annotation.Resource;

import com.blog.Dao.CheciMapper;
import com.blog.Dao.UserMapper;
import com.blog.service.CheciService;
import com.blog.service.OrderService;

public class CheciServiceImpl implements CheciService{
	@Resource
	private CheciMapper CheciDao;

}
