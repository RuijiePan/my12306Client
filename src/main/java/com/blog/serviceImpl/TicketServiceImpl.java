package com.blog.serviceImpl;

import com.blog.Dao.TicketMapper;
import com.blog.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	@Resource
	private TicketMapper ticketDao;
}
