package com.blog.serviceImpl;

import java.util.List;

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
	public void register(User user){
		userDao.insert(user);
	}
	@Override
	public User test(){
		User user =  new User();
		user.setUsername("username");
		return user;
	}

}
