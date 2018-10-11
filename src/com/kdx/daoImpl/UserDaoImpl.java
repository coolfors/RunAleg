package com.kdx.daoImpl;

import java.util.List;

import com.kdx.dao.UserDao;
import com.kdx.entity.User;
import com.kdx.util.BaseDao;

import sun.security.pkcs11.Secmod.DbMode;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		String sql="insert into user values(null,?,?,?,?,?)";
		return BaseDao.execute(sql,User.class,u.getUserName(),u.getUserPwd(),u.getSockState(),u.getUserType(),u.getUserdate())>0;
	}

	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		String sql="update user set  userName=?,userPwd=?,sockState=?,userType=?,userdate=? where userId=?";
		return BaseDao.execute(sql,User.class,u.getUserName(),u.getUserPwd(),u.getSockState(),u.getUserType(),u.getUserdate(),u.getUserId())>0;
		 
	}

	@Override
	public List<User> queryUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
