package com.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.Dao.CheciMapper;
import com.blog.service.CheciService;


@Service("checiService")
public class CheciServiceImpl implements CheciService{
	@Resource
	private CheciMapper CheciDao;

}
