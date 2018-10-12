package com.kdx.daoImpl;

import java.util.List;

import com.kdx.dao.UserDao;
import com.kdx.entity.User;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

/**
 * UserDao的实现类
 * 
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	// 增加用户
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into user(userName,userPwd,sockState,userType,userdate) values(?,?,?,?,?)";
		return BaseDao.execute(sql, u.getUserName(), u.getUserPwd(), u.getSockState(), u.getUserType(),
				u.getUserDate()) > 0;
	}

	// 更新用户
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		String sql = "update user set userName=?,userPwd=?,sockState=?,userType=?,userdate=? where userId=?";
		return BaseDao.execute(sql, u.getUserName(), u.getUserPwd(), u.getSockState(), u.getUserType(), u.getUserDate(),
u.getUserId()) > 0;

	}

	// 分页
	@Override
	public PageData queryUserByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from user", page, pageSize, User.class);
	}

	// 用户登录
	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		String sql = "select * from user where userName=?,userPwd=?";
		return (User) BaseDao.select(sql, User.class, userName, userPwd);

	}

	@Override
	public List<User> queryUser() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		return (List<User>) BaseDao.select(sql, User.class);
		
	}

}
