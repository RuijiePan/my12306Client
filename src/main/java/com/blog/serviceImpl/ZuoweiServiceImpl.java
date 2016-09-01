package com.blog.serviceImpl;

import com.blog.Dao.ZuoweiMapper;
import com.blog.service.ZuoweiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("zuoweiService")
public class ZuoweiServiceImpl implements ZuoweiService {
	@Resource
	private ZuoweiMapper zuoweiDao;
}
