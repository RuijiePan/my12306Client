package com.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.Dao.UserMapper;
import com.blog.entity.User;
import com.blog.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userDao;

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}


}
