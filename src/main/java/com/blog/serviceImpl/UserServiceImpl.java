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

	@Override
	public MyResponse getLinker(User user) {

		MyResponse myResponse = new MyResponse();
		User data = userDao.selectByPrimaryKey(user.getUid());
		if(data.getToken().equals(user.getToken())) {
			List<Link> list = linkDao.selectByUid(user.getUid());
			if (list != null) {
				myResponse.setData(list);
			} else {
				myResponse.setMsg("��ϵ���б�Ϊ��");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setMsg("��Ч��TOKEN");
			myResponse.setErrortype("TOKEN����");
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
					myResponse.setMsg("�����ɹ�");
				} else {
					myResponse.setStatus(MyResponse.ERROR);
					myResponse.setErrortype("");
				}
			} else {
				myResponse.setStatus(MyResponse.ERROR);
				myResponse.setErrortype("������ϵ��ʧ��");
				myResponse.setMsg("����ϵ���Ѿ�����");
			}
		}else {
			myResponse.setStatus(MyResponse.ERROR);
			myResponse.setErrortype("TOKEN����");
			myResponse.setMsg("TOKEN��Ч");
		}
		return myResponse;
	}
}
