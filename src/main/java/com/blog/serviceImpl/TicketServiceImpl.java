package com.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.Dao.TicketMapper;
import com.blog.Dao.UserMapper;
import com.blog.service.OrderService;
import com.blog.service.TicketService;
@Service("ticketService")
public class TicketServiceImpl implements TicketService{
	@Resource
	private TicketMapper ticketDao;
}
