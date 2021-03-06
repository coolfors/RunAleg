package com.kdx.serviceImpl;

import java.util.List;

import com.kdx.dao.UserDao;
import com.kdx.daoImpl.UserDaoImpl;
import com.kdx.entity.Evaluate;
import com.kdx.entity.User;
import com.kdx.service.UserService;
import com.kdx.util.PageData;

/**
 * 实现UserService接口的类
 * 
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {
	// 创建对象
	UserDao ud = new UserDaoImpl();

	// 增加用户
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

	// 更新用户
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}

	// 分页
	@Override
	public PageData<User> getUsersByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return ud.queryUserByPage(page, pageSize);
	}

	// 用户登录
	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return ud.loginUser(userName, userPwd);
	}
	
	//用于后台登陆
	@Override
	public User loginUserAdmin(String username, String pswsecrite) {
		// TODO Auto-generated method stub
		return ud.loginUserAdmin(username, pswsecrite);
	}
	//前台显示用户信息
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return ud.queryUser();
	}
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return ud.getUserById(userId);
	}

	@Override
	public boolean updateState(String userId, int sockState) {
		// TODO Auto-generated method stub
		return ud.changeState(userId, sockState);
	}

	@Override
	public boolean updateType(String userId, int userType) {
		// TODO Auto-generated method stub
		return ud.changeType(userId, userType);
	}

	@Override
	public List<User> queryUsersByName(String userName) {
		// TODO Auto-generated method stub
		return ud.queryUserName(userName);
	}

	@Override
	public List<User> queryUsersById(String userId) {
		// TODO Auto-generated method stub
		return ud.queryUserId(userId);
	}

	@Override
	public boolean resetPwd(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return ud.resetPwd(userId, userPwd);
	}

	@Override
	public List<User> againPwd(String userId) {
		// TODO Auto-generated method stub
		return ud.againPwd(userId);
	}

	//根据用户名查找用户类型
	@Override
	public List<User> findUserType(String userName) {
		// TODO Auto-generated method stub
		return ud.findUserType(userName);
	}

	@Override
	public PageData<Evaluate> queryEvalByPage(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		return ud.queryEvalByPage(page, pageSize, userId);
	}

	@Override
	public boolean changeEval(Evaluate eval) {
		// TODO Auto-generated method stub
		return ud.changeEval(eval);
	}
	

}
