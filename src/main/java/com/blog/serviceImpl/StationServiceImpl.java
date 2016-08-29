package com.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.Dao.StationMapper;
import com.blog.Dao.UserMapper;
import com.blog.service.OrderService;
import com.blog.service.StationService;
@Service("stationService")
public class StationServiceImpl implements StationService{
	@Resource
	private StationMapper stationDao;
}
