package com.blog.serviceImpl;

import com.blog.Dao.CheciMapper;
import com.blog.service.CheciService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("checiService")
public class CheciServiceImpl implements CheciService {
	@Resource
	private CheciMapper CheciDao;

}
