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
				myResponse.setMsg("ϵͳ�������Ժ�����");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("���û��Ѿ�����");
		}
		return myResponse;
	}

	@Override
	public MyResponse login(User user) {
		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByNamePwd(user);
		if (data==null){
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("�˺Ż��������");
		}else {
			data.setToken(UUIDUtil.createUUID());
			int count = userDao.updateByPrimaryKey(data);
			if(count!=0){
				myResponse.setMsg("��½�ɹ�");
			}else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setMsg("TOKEN��Ч");
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
				myResponse.setMsg("�˳��ɹ�");
			}else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setErrortype("ִ�и������ʧ��");
				myResponse.setMsg("����TOKENʧ��");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setErrortype("no_login");
			myResponse.setMsg("�˳�ʧ��");
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
			myResponse.setMsg("��Ч��TOKEN");
			myResponse.setErrortype("��ѯʧ��");
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
				myResponse.setMsg("���³ɹ�");
			}else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setErrortype("����ʧ��");
				myResponse.setMsg("���ݿ���³���");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("��Ч��TOKEN");
			myResponse.setErrortype("����ʧ��");
		}
		return myResponse;
	}

}
