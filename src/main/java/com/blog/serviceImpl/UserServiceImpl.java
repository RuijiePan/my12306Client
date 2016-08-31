package com.blog.serviceImpl;

import javax.annotation.Resource;

import com.blog.myresponse.MyResponse;
import com.blog.utils.CryptUtil;
import com.blog.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import com.blog.Dao.UserMapper;
import com.blog.entity.User;
import com.blog.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userDao;

	@Override
	public MyResponse register(User user) {
		MyResponse myResponse = new MyResponse();
		if (userDao.selectByName(user.getUsername())==0) {
			int index = userDao.insert(user);
			if (index < 0) {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setMsg("系统出错，请稍后再试");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("该用户已经存在");
		}
		return myResponse;
	}

	@Override
	public MyResponse login(User user) {
		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByNamePwd(user);
		if (data==null){
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("账号或密码错误");
		}else {
			data.setToken(UUIDUtil.createUUID());
			int count = userDao.updateByPrimaryKey(data);
			if(count!=0){
				myResponse.setMsg("登陆成功");
			}else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setMsg("TOKEN无效");
			}
			myResponse.setData(data);
		}
		return myResponse;
	}

	@Override
	public MyResponse quit(User user) {
		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByPrimaryKey(user.getUid());
		if(data.getToken().equals(user.getToken())){
			data.setToken(UUIDUtil.createUUID());
			int count = userDao.updateByPrimaryKey(data);
			if(count!=0) {
				myResponse.setMsg("退出成功");
			}else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setErrortype("执行更新语句失败");
				myResponse.setMsg("更新TOKEN失败");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setErrortype("no_login");
			myResponse.setMsg("退出失败");
		}
		return myResponse;
	}

	@Override
	public MyResponse getInfo(User user) {
		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByPrimaryKey(user.getUid());
		if (user.getToken().equals(data.getToken())){
			myResponse.setData(data);
		}else {
			myResponse.setMsg("无效的TOKEN");
			myResponse.setErrortype("查询失败");
			myResponse.setStatus(MyResponse.ERROR);
		}
		return myResponse;
	}

	@Override
	public MyResponse updateInfo(User user) {
		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByPrimaryKey(user.getUid());
		if (data.getToken().equals(user.getToken())){
			int count = userDao.updateByPrimaryKey(user);
			if (count!=0){
				myResponse.setMsg("更新成功");
			}else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setErrortype("更新失败");
				myResponse.setMsg("数据库更新出错");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("无效的TOKEN");
			myResponse.setErrortype("更新失败");
		}
		return myResponse;
	}

}
