package com.blog.service;


import com.blog.entity.Link;
import com.blog.entity.User;
import com.blog.myresponse.MyResponse;

public interface LinkService {
	MyResponse getLinker(User user);
	MyResponse insertLinker(Link link, User user);
}
