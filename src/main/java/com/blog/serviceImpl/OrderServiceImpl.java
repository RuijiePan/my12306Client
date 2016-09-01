package com.blog.serviceImpl;

import com.blog.Dao.OrderMapper;
import com.blog.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderMapper OrderDao;
}
