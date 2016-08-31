package com.blog.service;


import java.util.List;

import com.blog.entity.User;
import com.blog.myresponse.MyResponse;

public interface UserService {
	 MyResponse register(User user);
	 MyResponse login(User user);
	 MyResponse quit(User user);
	 MyResponse getInfo(User user);
	 MyResponse updateInfo(User user);
}
