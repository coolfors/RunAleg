package com.kdx.daoImpl;

import java.util.Iterator;
import java.util.List;

import com.kdx.dao.UserDao;
import com.kdx.entity.User;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;

import sun.security.pkcs11.Secmod.DbMode;

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
				u.getUserdate()) > 0;
	}

	// 更新用户
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		String sql = "update user set userPwd=?,sockState=?,userType=?,userdate=? where userId=?";
		return BaseDao.execute(sql, u.getUserPwd(), u.getSockState(), u.getUserType(), u.getUserdate(),
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
		String sql = "select * from user where userName=? and userPwd=?";
		List<User> list = (List<User>) BaseDao.select(sql, User.class, userName, userPwd);
		Iterator<User> it = list.iterator();
		User u = null;
		if (it.hasNext()) {
			u = it.next();
		}
		return u;

	}

}
