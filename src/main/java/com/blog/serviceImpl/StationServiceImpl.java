package com.blog.serviceImpl;

import com.blog.Dao.StationMapper;
import com.blog.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("stationService")
public class StationServiceImpl implements StationService {
	@Resource
	private StationMapper stationDao;
}
