package com.blog.serviceImpl;

import com.blog.Dao.LinkMapper;
import com.blog.Dao.UserMapper;
import com.blog.entity.Link;
import com.blog.entity.User;
import com.blog.myresponse.MyResponse;
import com.blog.service.LinkService;
import com.blog.service.UserService;
import com.blog.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService,LinkService {

	@Resource
	private UserMapper userDao;
	@Resource
	private LinkMapper linkDao;

	@Override
	public MyResponse register(User user) {

		user.setUrl("");
		user.setStatus(0);
		user.setToken(UUIDUtil.createUUID());

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
		System.out.println(myResponse.toString());
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

	@Override
	public MyResponse getLinker(User user) {

		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByPrimaryKey(user.getUid());
		if(data.getToken().equals(user.getToken())) {
			List<Link> list = linkDao.selectByUid(user.getUid());
			if (list != null) {
				myResponse.setData(list);
			} else {
				myResponse.setMsg("联系人列表为空");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("无效的TOKEN");
			myResponse.setErrortype("TOKEN错误");
		}
		return myResponse;
	}

	@Override
	public MyResponse insertLinker(Link link,User user){
		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByPrimaryKey(user.getUid());
		if(data.getToken().equals(user.getToken())) {
			if (linkDao.selectByIdcard(link.getIdcard()) == null) {
				int count = linkDao.insert(link);
				if (count != 0) {
					myResponse.setMsg("新增成功");
				} else {
					myResponse.setStatus(MyResponse.ERROR);
					myResponse.setErrortype("");
				}
			} else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setErrortype("新增联系人失败");
				myResponse.setMsg("该联系人已经存在");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setErrortype("TOKEN错误");
			myResponse.setMsg("TOKEN无效");
		}
		return myResponse;
	}
}
