package com.blog.serviceImpl;

import javax.annotation.Resource;

import com.blog.Dao.TicketMapper;
import com.blog.Dao.UserMapper;
import com.blog.service.OrderService;
import com.blog.service.TicketService;

public class TicketServiceImpl implements TicketService{
	@Resource
	private TicketMapper ticketDao;
}
