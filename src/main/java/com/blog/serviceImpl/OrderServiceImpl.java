package com.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.Dao.OrderMapper;
import com.blog.Dao.UserMapper;
import com.blog.service.OrderService;
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderMapper OrderDao;
}
