package com.kdx.serviceImpl;

import com.kdx.dao.UserDao;
import com.kdx.daoImpl.UserDaoImpl;
import com.kdx.entity.User;
import com.kdx.service.UserService;
import com.kdx.util.PageData;

public class UserServiceImpl implements UserService {
	//创建对象
	UserDao ud=new UserDaoImpl();
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}
	@Override
	public PageData getUsersByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return ud.queryUserByPage(page, pageSize);
	}
	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return ud.loginUser(userName, userPwd);
	}
	
}
