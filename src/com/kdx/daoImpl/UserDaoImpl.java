package com.kdx.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.kdx.dao.UserDao;
import com.kdx.entity.Dispatch;
import com.kdx.entity.Evaluate;
import com.kdx.entity.User;
import com.kdx.util.BaseDao;
import com.kdx.util.PageData;
import com.kdx.util.UUIDUtils;

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
		Object obj = BaseDao.select("select * from user where userName=?", User.class, u.getUserName());
		if (obj != null) {
			return false;
		} else {
			String sql = "insert into user(userName,sockState,userPwd,userType,userdate) values(?,0,?,?,?)";
			return BaseDao.execute(sql, u.getUserName(), u.getUserPwd(), u.getUserType(), u.getUserDate()) > 0;
		}

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
		return BaseDao.getPage("select * from user ", page, pageSize, User.class);
	}

	// 用户登录
	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user where username = ? and userpwd= ?";

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) BaseDao.select(sql, User.class, userName, userPwd);
		Iterator<User> it = list.iterator();
		User u = null;
		if (it.hasNext()) {
			u = it.next();
		}
		return u;

	}
	
	// 用户登录后台
	@Override
	public User loginUserAdmin(String userName, String userPwd) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user where username = ? and userpwd= ? and userType=0 ";

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) BaseDao.select(sql, User.class, userName, userPwd);
		Iterator<User> it = list.iterator();
		User u = null;
		if (it.hasNext()) {
			u = it.next();
		}
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
	public boolean changeState(String userId, int sockState) {
		// TODO Auto-generated method stub
		String sql = "update user set sockState=? where userId=?";
		return BaseDao.execute(sql, sockState, userId) > 0;
	}

	@Override
	public boolean changeType(String userId, int userType) {
		// TODO Auto-generated method stub
		String sql = "update user set userType=? where userId=?";
		return BaseDao.execute(sql, userType, userId) > 0;
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		List<User> list = (List<User>) BaseDao.select("select * from user where userId=?", User.class, userId);
		Iterator<User> it = list.iterator();
		User u = null;
		if (it.hasNext()) {
			u = it.next();
		}
		return u;
	}

	@Override
	public List<User> queryUserName(String userName) {
		// TODO Auto-generated method stub
		String sql = "select * from user where userName = ?";
		List<User> list = (List<User>) BaseDao.select(sql, User.class, userName);
		return list;
	}

	@Override
	public List<User> queryUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from user where userId = ?";
		List<User> list = (List<User>) BaseDao.select(sql, User.class, userId);
		return list;
	}

	@Override
	public boolean resetPwd(int userId, String userPwd) {
		// TODO Auto-generated method stub
		String sql = "update user set userPwd = ? where userId = ?";
		return BaseDao.execute(sql, userPwd, userId) > 0;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> againPwd(String userId) {
		// TODO Auto-generated method stub
		String sql = "select * from user where userId = ?";
		return (List<User>) BaseDao.select(sql, User.class, userId);

	}

	// 根据用户名查找用户类型
	@Override
	public List<User> findUserType(String userName) {
		// TODO Auto-generated method stub
		String sql = "select * from user where userName = ?";
		return (List<User>) BaseDao.select(sql, User.class, userName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageData<Evaluate> queryEvalByPage(int page, int pageSize, String userId) {
		// TODO Auto-generated method stub
		return BaseDao.getPage("select * from evaluate where userId = ?", page, pageSize, Evaluate.class, userId);
	}

	@Override
	public boolean changeEval(Evaluate e) {
		// TODO Auto-generated method stub
		String sql = "update evaluate set evaInfo = ? ,evaScore = ? , evaState = '1' where evaluateId = ?";
		return BaseDao.execute(sql, e.getEvaInfo(), e.getEvaScore(), e.getEvaluateId()) > 0;
	}

}
