package com.kdx.daoImpl;

import java.util.Iterator;
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
	// 修改增加用户语句：原型：insert into user(userName,userPwd,sockState,userType,userdate)
	// values(?,?,?,?,?)
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub

		String sql = "insert into user(userName,userPwd,userType,userdate) values(?,?,?,?)";
		return BaseDao.execute(sql, u.getUserName(), u.getUserPwd(), u.getUserType(), u.getUserDate()) > 0;

	}

	// 更新用户
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		String sql = "update user set userName=?,userPwd=?,userdate=? where userId=?";
		return BaseDao.execute(sql, u.getUserName(), u.getUserPwd(), u.getUserDate(), u.getUserId()) > 0;

	}

	// 分页
	@SuppressWarnings("unchecked")
	@Override
	public PageData<User> queryUserByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from user", page, pageSize, User.class);
	}

	// 用户登录
	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `user` where username = ? and userpwd= ?";

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) BaseDao.select(sql, User.class, userName, userPwd);
		Iterator<User> it = list.iterator();
		User u = null;
		if (it.hasNext()) {
			u = it.next();
		}
		System.out.println("user:"+u);
		return u;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryUser() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		return (List<User>) BaseDao.select(sql, User.class);

	}

	@Override
	public boolean changeState(int userId, int sockState) {
		// TODO Auto-generated method stub
		String sql = "update user set sockState=? where userId=?";
		return BaseDao.execute(sql, sockState, userId) > 0;
	}

	@Override
	public boolean changeType(int userId, int userType) {
		// TODO Auto-generated method stub
		String sql = "update user set userType=? where userId=?";
		return BaseDao.execute(sql, userType, userId) > 0;
	}

}
