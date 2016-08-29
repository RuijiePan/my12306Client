package com.blog.serviceImpl;

import javax.annotation.Resource;

import com.blog.Dao.OrderMapper;
import com.blog.Dao.UserMapper;
import com.blog.service.OrderService;

public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderMapper OrderDao;
}
